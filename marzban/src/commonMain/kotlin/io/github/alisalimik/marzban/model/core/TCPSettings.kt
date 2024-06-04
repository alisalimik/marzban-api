package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.Serializable

@Serializable
data class TCPSettings(
    val header: Header? = null,
)
