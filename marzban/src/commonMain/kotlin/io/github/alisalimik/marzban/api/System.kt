package io.github.alisalimik.marzban.api

import io.github.alisalimik.marzban.MarzbanClient
import io.github.alisalimik.marzban.model.ApiResult
import io.github.alisalimik.marzban.model.system.Host
import io.github.alisalimik.marzban.model.system.Inbound
import io.github.alisalimik.marzban.model.system.SystemStats
import io.ktor.http.*

class System(private val client: MarzbanClient) {
    suspend fun stats(): ApiResult<SystemStats> {
        return client.makeAuthorizedRequest("/api/system")
    }

    suspend fun inbounds(): ApiResult<Map<String, Inbound>> {
        return client.makeAuthorizedRequest("/api/system/inbounds")
    }

    suspend fun hosts(): ApiResult<Map<String, Host>> {
        return client.makeAuthorizedRequest("/api/system/hosts")
    }

    suspend fun editHosts(hosts: Map<String, Host>): ApiResult<Map<String, Host>> {
        return client.makeAuthorizedRequest("/api/system/hosts", HttpMethod.Put, hosts)
    }
}
