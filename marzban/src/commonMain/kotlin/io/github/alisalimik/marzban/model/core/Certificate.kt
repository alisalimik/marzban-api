package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.Serializable

@Serializable
data class Certificate(
    val certificate: List<String>,
    val key: List<String>,
)
