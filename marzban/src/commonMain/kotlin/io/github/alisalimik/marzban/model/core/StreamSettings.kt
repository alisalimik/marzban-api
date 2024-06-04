package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.Serializable

@Serializable
data class StreamSettings(
    val network: String,
    val tcpSettings: TCPSettings? = null,
    val security: String,
    val wsSettings: WsSettings? = null,
    val realitySettings: RealitySettings? = null,
    val grpcSettings: GrpcSettings? = null,
    val tlsSettings: TLSSettings? = null,
)
