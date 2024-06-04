package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.Serializable

@Serializable
data class Sniffing(
    val enabled: Boolean,
    val destOverride: List<DestOverride>,
)
