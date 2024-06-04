package io.github.alisalimik.marzban.model.node

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewNode(
    val name: String,
    val address: String,
    val port: Long,
    @SerialName("api_port")
    val apiPort: Long,
    @SerialName("add_as_new_host")
    val addAsNewHost: Boolean,
    @SerialName("usage_coefficient")
    val usageCoefficient: Long,
)
