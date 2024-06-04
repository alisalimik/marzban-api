package io.github.alisalimik.marzban.model.core

import kotlinx.serialization.Serializable

@Serializable
data class CoreConfig(
    val log: Log,
    val inbounds: List<Inbound>,
    val outbounds: List<Outbound>,
    val routing: Routing,
)
