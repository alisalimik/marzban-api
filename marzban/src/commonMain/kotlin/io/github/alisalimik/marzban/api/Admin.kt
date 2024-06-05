package io.github.alisalimik.marzban.api

import io.github.alisalimik.marzban.MarzbanClient
import io.github.alisalimik.marzban.UrlEncoder.setForm
import io.github.alisalimik.marzban.model.ApiResult
import io.github.alisalimik.marzban.model.admin.Admin
import io.github.alisalimik.marzban.model.admin.TokenResponse
import io.ktor.client.request.*
import io.ktor.http.*

class Admin(private val client: MarzbanClient) {
    suspend fun token(
        username: String,
        password: String,
    ): ApiResult<TokenResponse> {
        return client.makeApiRequest {
            post("/api/admin/token") {
                setForm(
                    mapOf(
                        "username" to username,
                        "password" to password,
                    ),
                )
            }
        }
    }

    suspend fun get(): ApiResult<Admin> {
        return client.makeAuthorizedRequest("/api/admin")
    }

    suspend fun all(): ApiResult<List<Admin>> {
        return client.makeAuthorizedRequest("/api/admins")
    }

    suspend fun add(admin: Admin): ApiResult<Admin> {
        return client.makeAuthorizedRequest("/api/admin", HttpMethod.Post, admin)
    }

    suspend fun edit(admin: Admin): ApiResult<Admin> {
        return client.makeAuthorizedRequest(
            "/api/admin/${admin.username}",
            HttpMethod.Put,
            admin,
        )
    }

    suspend fun delete(admin: Admin): ApiResult<Any> {
        return client.makeAuthorizedRequest("/api/admin/${admin.username}", HttpMethod.Delete)
    }
}
