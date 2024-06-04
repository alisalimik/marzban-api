package io.github.alisalimik.marzban.api

import io.github.alisalimik.marzban.Client.makeApiRequest
import io.github.alisalimik.marzban.Client.makeAuthorizedRequest
import io.github.alisalimik.marzban.UrlEncoder.setForm
import io.github.alisalimik.marzban.model.ApiResult
import io.github.alisalimik.marzban.model.admin.Admin
import io.github.alisalimik.marzban.model.admin.TokenResponse
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.http.HttpMethod

object Admin {
    suspend fun token(
        username: String,
        password: String,
    ): ApiResult<TokenResponse> {
        return makeApiRequest {
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
        return makeApiRequest {
            get("/api/admin")
        }
    }

    suspend fun all(): ApiResult<List<Admin>> {
        return makeApiRequest {
            get("/api/admins")
        }
    }

    suspend fun add(admin: Admin): ApiResult<Admin> {
        return makeAuthorizedRequest("/api/admin", HttpMethod.Post, admin)
    }

    suspend fun edit(admin: Admin): ApiResult<Admin> {
        return makeAuthorizedRequest(
            "/api/admin/${admin.username}",
            HttpMethod.Put,
            admin,
        )
    }

    suspend fun delete(admin: Admin): ApiResult<Any> {
        return makeAuthorizedRequest("/api/admin/${admin.username}", HttpMethod.Delete)
    }
}
