package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoreStats(
    val version: String,
    val started: Boolean,
    @SerialName("logs_websocket")
    val logsWebsocket: String,
)
