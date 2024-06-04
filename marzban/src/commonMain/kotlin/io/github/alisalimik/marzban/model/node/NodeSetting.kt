package io.github.alisalimik.marzban.model.node

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NodeSetting(
    @SerialName("min_node_version")
    val minNodeVersion: String,
    val certificate: String,
)
