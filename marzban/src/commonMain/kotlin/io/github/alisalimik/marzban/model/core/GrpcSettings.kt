package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.Serializable

@Serializable
data class GrpcSettings(
    val serviceName: String,
)
