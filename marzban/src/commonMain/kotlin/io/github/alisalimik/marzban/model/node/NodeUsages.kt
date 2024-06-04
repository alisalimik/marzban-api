package io.github.alisalimik.marzban.model.node

import kotlinx.serialization.Serializable

@Serializable
data class NodeUsages(
    val usages: List<Usage>,
)
