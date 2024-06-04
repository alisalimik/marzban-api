package io.github.alisalimik.marzban.model.node

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Node(
    val name: String,
    val address: String,
    val port: Long,
    @SerialName("api_port")
    val apiPort: Long,
    @SerialName("usage_coefficient")
    val usageCoefficient: Long,
    val id: Long,
    @SerialName("xray_version")
    val xrayVersion: String,
    val status: String,
    val message: String,
)
