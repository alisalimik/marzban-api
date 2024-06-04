package io.github.alisalimik.marzban.api

import io.github.alisalimik.marzban.Client.makeAuthorizedRequest
import io.github.alisalimik.marzban.model.ApiResult
import io.github.alisalimik.marzban.model.template.NewTemplate
import io.github.alisalimik.marzban.model.template.Template
import io.ktor.http.HttpMethod

object UserTemplate {
    suspend fun get(
        offset: Int,
        limit: String,
    ): ApiResult<List<Template>> {
        return makeAuthorizedRequest(
            "/api/user_template",
            body =
                mapOf(
                    "offset" to offset,
                    "limit" to limit,
                ),
        )
    }

    suspend fun add(newTemplate: NewTemplate): ApiResult<Unit> {
        return makeAuthorizedRequest("/api/user_template", HttpMethod.Post, body = newTemplate)
    }

    suspend fun getById(id: Int): ApiResult<Template> {
        return makeAuthorizedRequest("/api/user_template/$id")
    }

    suspend fun edit(template: Template): ApiResult<Template> {
        return makeAuthorizedRequest(
            "/api/user_template/${template.id}",
            HttpMethod.Put,
            template,
        )
    }

    suspend fun delete(id: Int): ApiResult<Any> {
        return makeAuthorizedRequest<Any>("/api/user_template/$id", HttpMethod.Delete)
    }
}
