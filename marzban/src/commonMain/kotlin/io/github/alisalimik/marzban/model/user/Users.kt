package io.github.alisalimik.marzban.model.user

import kotlinx.serialization.Serializable

@Serializable
data class Users(
    val users: List<User>,
    val total: Long,
)
