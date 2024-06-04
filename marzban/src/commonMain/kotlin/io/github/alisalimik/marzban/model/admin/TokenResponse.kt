package io.github.alisalimik.marzban.model.admin

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenResponse(
    @SerialName("access_token")
    val token: String,
    @SerialName("token_type")
    val tokenType: String = "Bearer",
)
