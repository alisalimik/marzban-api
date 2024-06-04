package io.github.alisalimik.marzban.model.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewUser(
    val username: String,
    val proxies: Proxies,
    val inbounds: Inbounds,
    val expire: Long,
    @SerialName("data_limit")
    val dataLimit: Long,
    @SerialName("data_limit_reset_strategy")
    val dataLimitResetStrategy: String,
    val status: String,
    val note: String,
    @SerialName("on_hold_timeout")
    val onHoldTimeout: String,
    @SerialName("on_hold_expire_duration")
    val onHoldExpireDuration: Long,
)
