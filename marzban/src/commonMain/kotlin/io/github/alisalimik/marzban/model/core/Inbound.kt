package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.Serializable

@Serializable
data class Inbound(
    val tag: String,
    val listen: String,
    val port: Long,
    val protocol: String,
    val settings: Settings,
    val streamSettings: StreamSettings? = null,
    val sniffing: Sniffing? = null,
)
