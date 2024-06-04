package io.github.alisalimik.marzban.model.template

import io.github.alisalimik.marzban.model.user.Inbounds
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Template(
    val name: String,
    @SerialName("data_limit")
    val dataLimit: Long,
    @SerialName("expire_duration")
    val expireDuration: Long,
    @SerialName("username_prefix")
    val usernamePrefix: String,
    @SerialName("username_suffix")
    val usernameSuffix: String,
    val inbounds: Inbounds,
    val id: Long,
)
