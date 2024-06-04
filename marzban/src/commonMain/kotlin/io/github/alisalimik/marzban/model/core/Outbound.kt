package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.Serializable

@Serializable
data class Outbound(
    val protocol: String,
    val tag: String,
)
