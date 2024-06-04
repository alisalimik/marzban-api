package io.github.alisalimik.marzban.model.error

import kotlinx.serialization.Serializable

@Serializable
data class BadResponse(
    val detail: List<Detail>,
)
