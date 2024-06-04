package io.github.alisalimik.marzban.model.template

import io.github.alisalimik.marzban.model.user.Inbounds
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewTemplate(
    val name: String,
    val inbounds: Inbounds,
    @SerialName("data_limit")
    val dataLimit: Long,
    @SerialName("expire_duration")
    val expireDuration: Long,
)
