package io.github.alisalimik.marzban.model.admin

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Admin(
    val username: String,
    @SerialName("is_sudo")
    val isSudo: Boolean,
    @SerialName("telegram_id")
    val telegramID: Long? = null,
    @SerialName("discord_webhook")
    val discordWebhook: String? = null,
    val password: String? = null,
)
