package io.github.alisalimik.marzban.api

import io.github.alisalimik.marzban.Client.makeAuthorizedRequest
import io.github.alisalimik.marzban.model.ApiResult
import io.github.alisalimik.marzban.model.core.CoreConfig
import io.github.alisalimik.marzban.model.core.CoreStats
import io.github.alisalimik.marzban.model.core.Response
import io.ktor.http.*

object Core {
    suspend fun stats(): ApiResult<CoreStats> {
        return makeAuthorizedRequest("/api/core", HttpMethod.Get)
    }

    suspend fun restart(): ApiResult<Response> {
        return makeAuthorizedRequest<Response>("/api/core/restart", HttpMethod.Post)
    }

    suspend fun getConfig(): ApiResult<CoreConfig> {
        return makeAuthorizedRequest("/api/core/config", HttpMethod.Get)
    }

    suspend fun editConfig(body: CoreConfig): ApiResult<CoreConfig> {
        return makeAuthorizedRequest("/api/core/config", HttpMethod.Put, body)
    }
}
