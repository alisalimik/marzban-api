package io.github.alisalimik.marzban

import io.github.alisalimik.marzban.model.ApiResult
import io.github.alisalimik.marzban.model.MarzbanConfig
import io.github.alisalimik.marzban.model.error.BadResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.utils.io.errors.*
import kotlinx.serialization.json.Json

object Client {
    lateinit var config: MarzbanConfig
    private var engine: HttpClientEngine = CIO.create()
    fun initConfig(config: MarzbanConfig) {
        this.config = config
    }

    private val json by lazy {
        Json {
            ignoreUnknownKeys = true
        }
    }
    val httpClient by lazy {
        HttpClient(engine) {
            install(ContentNegotiation) {
                json(json = json)
            }
            defaultRequest {
                url {
                    url(config.url)
                    accept(ContentType.Application.Json)
                    contentType(ContentType.Application.FormUrlEncoded)
                }
            }
        }
    }

    suspend inline fun <reified T> makeAuthorizedRequest(
        path: String,
        method: HttpMethod = HttpMethod.Get,
        body: Any? = null,
        headers: Map<String, String> = emptyMap(),
    ): ApiResult<T> {
        return makeApiRequest {
            request {
                url("${config.url}$path")
                this.method = method
                headers {
                    append(HttpHeaders.Accept, ContentType.Application.Json)
                    append(HttpHeaders.ContentType, ContentType.Application.Json)
                    config.token?.let { append(HttpHeaders.Authorization, "Bearer $it") }
                    headers.forEach {
                        append(it.key, it.value)
                    }
                }
                if (body != null) {
                    if (method == HttpMethod.Get && body is Map<*, *>) {
                        parameters {
                            for ((key, value) in body) {
                                this.append(key.toString(), value.toString())
                            }
                        }
                    }
                    setBody(body)
                }
            }
        }
    }

    suspend inline fun <reified T> makeApiRequest(crossinline request: suspend HttpClient.() -> HttpResponse): ApiResult<T> {
        return try {
            val response = httpClient.request()
            when (response.status.value) {
                in 200..299 -> { // Successful response
                    val data = response.body<T>()
                    ApiResult.Success(data)
                }

                else -> { // Handle other status codes as errors
                    val badResponse = response.body<BadResponse?>()
                    if (badResponse != null) {
                        ApiResult.ErrorResponse(response.status.value, badResponse)
                    } else {
                        val message = response.body<String>() // Get error message from response body
                        ApiResult.Error(Exception("API Error: $message"))
                    }
                }
            }
        } catch (e: IOException) {
            // Network exceptions
            ApiResult.Error(Exception("Network Error: ${e.message}"))
        } catch (e: Exception) {
            // Other unexpected exceptions
            ApiResult.Error(Exception("Unexpected Error: ${e.message}"))
        }
    }
}
