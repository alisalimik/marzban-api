package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.Serializable

@Serializable
data class Request(
    val method: String,
    val path: List<String>,
    val headers: RequestHeaders,
)
