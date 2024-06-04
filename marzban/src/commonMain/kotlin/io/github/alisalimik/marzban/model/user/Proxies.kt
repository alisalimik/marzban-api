package io.github.alisalimik.marzban.model.user

import kotlinx.serialization.Serializable

@Serializable
data class Proxies(
    val vmess: Map<String, String>,
    val vless: Map<String, String>,
)
