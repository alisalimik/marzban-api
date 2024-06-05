package io.github.alisalimik.marzban.model.error

import kotlinx.serialization.Serializable

@Serializable
sealed class BadResponse {
    @Serializable
    data class TextDetail(val detail: String) : BadResponse()

    @Serializable
    data class ListDetail(val detail: List<Detail>) : BadResponse()
}
