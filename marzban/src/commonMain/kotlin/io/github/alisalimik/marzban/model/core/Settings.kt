package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray

@Serializable
data class Settings(
    val clients: JsonArray,
    val decryption: String? = null,
    val network: String? = null,
)
