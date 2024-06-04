package io.github.alisalimik.marzban.model.user

import kotlinx.serialization.Serializable

@Serializable
data class Inbounds(
    val vmess: List<String>,
    val vless: List<String>,
)
