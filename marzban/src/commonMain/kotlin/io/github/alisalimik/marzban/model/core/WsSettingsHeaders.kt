package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WsSettingsHeaders(
    @SerialName("Host")
    val host: String,
)
