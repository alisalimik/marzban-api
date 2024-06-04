package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.Serializable

@Serializable
data class WsSettings(
    val path: String,
    val headers: WsSettingsHeaders,
)
