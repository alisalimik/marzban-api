package io.github.alisalimik.marzban.model.system

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SystemStats(
    val version: String,
    @SerialName("mem_total")
    val memTotal: Long,
    @SerialName("mem_used")
    val memUsed: Long,
    @SerialName("cpu_cores")
    val cpuCores: Long,
    @SerialName("cpu_usage")
    val cpuUsage: Float,
    @SerialName("total_user")
    val totalUser: Long,
    @SerialName("users_active")
    val usersActive: Long,
    @SerialName("incoming_bandwidth")
    val incomingBandwidth: Long,
    @SerialName("outgoing_bandwidth")
    val outgoingBandwidth: Long,
    @SerialName("incoming_bandwidth_speed")
    val incomingBandwidthSpeed: Long,
    @SerialName("outgoing_bandwidth_speed")
    val outgoingBandwidthSpeed: Long,
)
