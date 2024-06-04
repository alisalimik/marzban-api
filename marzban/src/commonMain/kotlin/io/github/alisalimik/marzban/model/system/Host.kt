package io.github.alisalimik.marzban.model.system

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Host(
    val remark: String,
    val address: String,
    val port: Long,
    val sni: String,
    val host: String,
    val path: String,
    val security: String,
    val alpn: String,
    val fingerprint: String,
    val allowinsecure: Boolean,
    @SerialName("is_disabled")
    val isDisabled: Boolean,
)
