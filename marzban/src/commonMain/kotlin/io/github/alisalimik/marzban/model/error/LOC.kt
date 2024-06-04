package io.github.alisalimik.marzban.model.error

import kotlinx.serialization.Serializable

@Serializable
sealed class LOC {
    class IntegerValue(val value: Long) : LOC()

    class StringValue(val value: String) : LOC()
}
