package io.github.alisalimik.marzban.model.error

import kotlinx.serialization.Serializable

@Serializable
data class Detail(
    val loc: List<LOC>,
    val msg: String,
    val type: String,
)
