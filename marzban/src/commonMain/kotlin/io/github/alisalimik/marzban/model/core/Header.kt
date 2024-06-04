package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.Serializable

@Serializable
data class Header(
    val type: DestOverride,
    val request: Request,
    val response: Response,
)
