package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class DestOverride(val value: String) {
    @SerialName("http")
    HTTP("http"),

    @SerialName("tls")
    TLS("tls"),
}
