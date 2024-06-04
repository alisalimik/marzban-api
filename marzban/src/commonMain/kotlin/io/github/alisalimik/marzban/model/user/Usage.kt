package io.github.alisalimik.marzban.model.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Usage(
    @SerialName("node_id")
    val nodeID: Long,
    @SerialName("node_name")
    val nodeName: String,
    @SerialName("used_traffic")
    val usedTraffic: Long,
)
