package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.Serializable

@Serializable
data class TLSSettings(
    val certificates: List<Certificate>,
    val minVersion: String,
    val cipherSuites: String,
)
