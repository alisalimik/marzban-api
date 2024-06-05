package io.github.alisalimik.marzban.api

import io.github.alisalimik.marzban.MarzbanClient
import io.github.alisalimik.marzban.model.ApiResult
import io.github.alisalimik.marzban.model.user.User

class Subscription(private val client: MarzbanClient) {
    suspend fun get(
        token: String,
        userAgent: String = "V2ray",
    ): ApiResult<String> {
        return client.makeAuthorizedRequest("/sub/$token", headers = mapOf("user-agent" to userAgent))
    }

    suspend fun usage(
        token: String,
        start: String,
        end: String,
    ): ApiResult<String> {
        return client.makeAuthorizedRequest(
            "/sub/$token/usage",
            body =
                mapOf(
                    "start" to start,
                    "end" to end,
                ),
        )
    }

    suspend fun info(token: String): ApiResult<User> {
        return client.makeAuthorizedRequest("/sub/$token/info")
    }

    suspend fun getByClient(
        token: String,
        clientType: String = "v2ray",
    ): ApiResult<String> {
        return client.makeAuthorizedRequest("/sub/$token/$clientType")
    }
}
