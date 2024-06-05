package io.github.alisalimik.marzban.api

import io.github.alisalimik.marzban.MarzbanClient
import io.github.alisalimik.marzban.model.ApiResult
import io.github.alisalimik.marzban.model.node.NewNode
import io.github.alisalimik.marzban.model.node.Node
import io.github.alisalimik.marzban.model.node.NodeSetting
import io.github.alisalimik.marzban.model.node.NodeUsages
import io.ktor.http.*

class Node(private val client: MarzbanClient) {
    suspend fun settings(): ApiResult<NodeSetting> {
        return client.makeAuthorizedRequest("/api/node/settings")
    }

    suspend fun all(): ApiResult<List<Node>> {
        return client.makeAuthorizedRequest("/api/nodes")
    }

    suspend fun usage(
        start: String,
        end: String,
    ): ApiResult<NodeUsages> {
        return client.makeAuthorizedRequest(
            "/api/nodes/usage",
            body =
                mapOf(
                    "start" to start,
                    "end" to end,
                ),
        )
    }

    suspend fun add(newNode: NewNode): ApiResult<Node> {
        return client.makeAuthorizedRequest("/api/nodes/add", HttpMethod.Post, body = newNode)
    }

    suspend fun get(nodeId: Int): ApiResult<Node> {
        return client.makeAuthorizedRequest("/api/node/$nodeId")
    }

    suspend fun edit(
        nodeId: Int,
        node: NewNode,
    ): ApiResult<Node> {
        return client.makeAuthorizedRequest(
            "/api/node/$nodeId",
            HttpMethod.Put,
            node,
        )
    }

    suspend fun delete(nodeId: Int): ApiResult<Any> {
        return client.makeAuthorizedRequest<Any>("/api/node/$nodeId", HttpMethod.Delete)
    }

    suspend fun reconnect(nodeId: Int): ApiResult<Any> {
        return client.makeAuthorizedRequest<Any>("/api/node/$nodeId/reconnect", HttpMethod.Post)
    }
}
