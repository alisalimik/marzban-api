package io.github.alisalimik.marzban.model

data class MarzbanConfig(
    val url: String,
    val username: String? = null,
    val password: String? = null,
    val token: String? = null,
)
