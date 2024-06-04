package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.Serializable

@Serializable
data class Rule(
    val ip: List<String>? = null,
    val outboundTag: String,
    val type: String,
    val domain: List<String>? = null,
    val protocol: List<String>? = null,
)
