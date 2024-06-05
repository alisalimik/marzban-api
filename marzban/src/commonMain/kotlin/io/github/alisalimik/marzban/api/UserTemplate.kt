package io.github.alisalimik.marzban.api

import io.github.alisalimik.marzban.MarzbanClient
import io.github.alisalimik.marzban.model.ApiResult
import io.github.alisalimik.marzban.model.template.NewTemplate
import io.github.alisalimik.marzban.model.template.Template
import io.ktor.http.*

class UserTemplate(private val client: MarzbanClient) {
    suspend fun get(
        offset: Int,
        limit: String,
    ): ApiResult<List<Template>> {
        return client.makeAuthorizedRequest(
            "/api/user_template",
            body =
                mapOf(
                    "offset" to offset,
                    "limit" to limit,
                ),
        )
    }

    suspend fun add(newTemplate: NewTemplate): ApiResult<Unit> {
        return client.makeAuthorizedRequest("/api/user_template", HttpMethod.Post, body = newTemplate)
    }

    suspend fun getById(id: Int): ApiResult<Template> {
        return client.makeAuthorizedRequest("/api/user_template/$id")
    }

    suspend fun edit(template: Template): ApiResult<Template> {
        return client.makeAuthorizedRequest(
            "/api/user_template/${template.id}",
            HttpMethod.Put,
            template,
        )
    }

    suspend fun delete(id: Int): ApiResult<Any> {
        return client.makeAuthorizedRequest<Any>("/api/user_template/$id", HttpMethod.Delete)
    }
}
