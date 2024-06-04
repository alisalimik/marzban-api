package io.github.alisalimik.marzban.api

import io.github.alisalimik.marzban.Client.makeAuthorizedRequest
import io.github.alisalimik.marzban.model.ApiResult
import io.github.alisalimik.marzban.model.system.Host
import io.github.alisalimik.marzban.model.system.Inbound
import io.github.alisalimik.marzban.model.system.SystemStats
import io.ktor.http.HttpMethod

object System {
    suspend fun stats(): ApiResult<SystemStats> {
        return makeAuthorizedRequest("/api/system")
    }

    suspend fun inbounds(): ApiResult<Map<String, Inbound>> {
        return makeAuthorizedRequest("/api/system/inbounds")
    }

    suspend fun hosts(): ApiResult<Map<String, Host>> {
        return makeAuthorizedRequest("/api/system/hosts")
    }

    suspend fun editHosts(hosts: Map<String, Host>): ApiResult<Map<String, Host>> {
        return makeAuthorizedRequest("/api/system/hosts", HttpMethod.Put, hosts)
    }
}
