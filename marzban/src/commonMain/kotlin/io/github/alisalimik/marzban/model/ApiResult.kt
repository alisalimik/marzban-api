package io.github.alisalimik.marzban.model

import io.github.alisalimik.marzban.model.error.BadResponse

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()

    data class ErrorResponse(val code: Int, val response: BadResponse?) : ApiResult<Nothing>()

    data class Error(val exception: Throwable) : ApiResult<Nothing>()
}
