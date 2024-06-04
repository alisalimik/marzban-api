package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RealitySettings(
    val show: Boolean,
    val dest: String,
    @SerialName("xver")
    val xVer: Long,
    val serverNames: List<String>,
    val privateKey: String,
    @SerialName("shortIds")
    val shortIDS: List<String>,
)
