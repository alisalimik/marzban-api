package io.github.alisalimik.marzban.api

import io.github.alisalimik.marzban.Client
import io.github.alisalimik.marzban.Client.makeApiRequest
import io.github.alisalimik.marzban.Client.makeAuthorizedRequest
import io.github.alisalimik.marzban.model.ApiResult
import io.github.alisalimik.marzban.model.user.NewUser
import io.github.alisalimik.marzban.model.user.User
import io.github.alisalimik.marzban.model.user.UserUsage
import io.github.alisalimik.marzban.model.user.Users
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.put
import io.ktor.http.HttpMethod
import io.ktor.http.parameters

object User {
    suspend fun add(newUser: NewUser): ApiResult<User> {
        return makeAuthorizedRequest(
            "/api/user",
            HttpMethod.Post,
            newUser,
        )
    }

    suspend fun get(username: String): ApiResult<User> {
        return makeAuthorizedRequest("/api/user/$username")
    }

    suspend fun edit(user: User): ApiResult<User> {
        return makeAuthorizedRequest(
            "/api/user/${user.username}",
            HttpMethod.Put,
            user,
        )
    }

    suspend fun delete(username: String): ApiResult<Any> {
        return makeAuthorizedRequest("/api/user/$username", HttpMethod.Delete)
    }

    suspend fun resetUser(username: String): ApiResult<Any> {
        return makeAuthorizedRequest<Any>("/api/user/$username/reset", HttpMethod.Post)
    }

    suspend fun resetUsers(): ApiResult<Any> {
        return makeAuthorizedRequest<Any>("/api/users/reset", HttpMethod.Post)
    }

    suspend fun revokeSubUser(username: String): ApiResult<Any> {
        return makeAuthorizedRequest<Any>("/api/user/$username/revoke_sub", HttpMethod.Post)
    }

    suspend fun all(
        offset: Int = 0,
        limit: Int = 0,
        username: String? = null,
        status: String? = null,
        sort: String? = null,
    ): ApiResult<Users> {
        return makeAuthorizedRequest(
            "/api/users",
            body =
                mapOf(
                    "offset" to offset,
                    "limit" to limit,
                    "username" to username,
                    "status" to status,
                    "sort" to sort,
                ),
        )
    }

    suspend fun usage(
        username: String,
        start: String? = null,
        end: String? = null,
    ): ApiResult<UserUsage> {
        return makeAuthorizedRequest(
            "/api/user/$username/usage",
            body =
                mapOf(
                    "start" to start,
                    "end" to end,
                ),
        )
    }

    suspend fun setOwner(
        username: String,
        admin: String,
    ): ApiResult<User> {
        return makeApiRequest {
            put("/api/user/$username/set-owner") {
                headers.append("Authorization", "Bearer ${Client.config.token}")
                parameters {
                    append("admin_username", admin)
                }
            }
        }
    }

    suspend fun getExpired(
        before: String,
        after: String,
    ): ApiResult<List<String>> {
        return makeApiRequest {
            get("/api/users/expired") {
                headers.append("Authorization", "Bearer ${Client.config.token}")
                parameters {
                    append("expired_before", before)
                    append("expired_after", after)
                }
            }
        }
    }

    suspend fun deleteExpired(
        before: String,
        after: String,
    ): ApiResult<List<String>> {
        return makeApiRequest {
            delete("/api/users/expired") {
                headers.append("Authorization", "Bearer ${Client.config.token}")
                parameters {
                    append("expired_before", before)
                    append("expired_after", after)
                }
            }
        }
    }
}
