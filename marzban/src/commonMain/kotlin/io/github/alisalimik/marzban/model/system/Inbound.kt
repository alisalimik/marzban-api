package io.github.alisalimik.marzban.model.system

import kotlinx.serialization.Serializable

@Serializable
data class Inbound(
    val tag: String,
    val protocol: String,
    val network: String,
    val tls: String,
    val port: Long,
)
