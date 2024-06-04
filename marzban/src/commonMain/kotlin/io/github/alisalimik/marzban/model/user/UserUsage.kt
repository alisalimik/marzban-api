package io.github.alisalimik.marzban.model.user

import kotlinx.serialization.Serializable

@Serializable
data class UserUsage(
    val username: String,
    val usages: List<Usage>,
)
