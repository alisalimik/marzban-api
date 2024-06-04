package io.github.alisalimik.marzban.model.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray

@Serializable
data class User(
    val proxies: ExcludedInbounds,
    val expire: Long,
    @SerialName("data_limit")
    val dataLimit: Long,
    @SerialName("data_limit_reset_strategy")
    val dataLimitResetStrategy: String,
    val inbounds: ExcludedInbounds,
    val note: String,
    @SerialName("sub_updated_at")
    val subUpdatedAt: String,
    @SerialName("sub_last_user_agent")
    val subLastUserAgent: String,
    @SerialName("online_at")
    val onlineAt: String,
    @SerialName("on_hold_expire_duration")
    val onHoldExpireDuration: Long,
    @SerialName("on_hold_timeout")
    val onHoldTimeout: String,
    val username: String,
    val status: String,
    @SerialName("used_traffic")
    val usedTraffic: Long,
    @SerialName("lifetime_used_traffic")
    val lifetimeUsedTraffic: Long,
    @SerialName("created_at")
    val createdAt: String,
    val links: JsonArray,
    @SerialName("subscription_url")
    val subscriptionURL: String,
    @SerialName("excluded_inbounds")
    val excludedInbounds: ExcludedInbounds,
)
