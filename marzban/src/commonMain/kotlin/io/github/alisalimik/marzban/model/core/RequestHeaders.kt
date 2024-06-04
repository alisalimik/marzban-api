package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestHeaders(
    @SerialName("Host")
    val host: List<String>,
)
