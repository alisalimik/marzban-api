package io.github.alisalimik.marzban.api

import io.github.alisalimik.marzban.MarzbanClient
import io.github.alisalimik.marzban.model.ApiResult
import io.github.alisalimik.marzban.model.core.CoreConfig
import io.github.alisalimik.marzban.model.core.CoreStats
import io.github.alisalimik.marzban.model.core.Response
import io.ktor.http.*

class Core(private val client: MarzbanClient) {
    suspend fun stats(): ApiResult<CoreStats> {
        return client.makeAuthorizedRequest("/api/core", HttpMethod.Get)
    }

    suspend fun restart(): ApiResult<Response> {
        return client.makeAuthorizedRequest<Response>("/api/core/restart", HttpMethod.Post)
    }

    suspend fun getConfig(): ApiResult<CoreConfig> {
        return client.makeAuthorizedRequest("/api/core/config", HttpMethod.Get)
    }

    suspend fun editConfig(body: CoreConfig): ApiResult<CoreConfig> {
        return client.makeAuthorizedRequest("/api/core/config", HttpMethod.Put, body)
    }
}
