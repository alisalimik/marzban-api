package io.github.alisalimik.marzban

import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.setBody

internal object UrlEncoder {
    fun HttpRequestBuilder.setForm(body: Map<String, String>) {
        setBody(body.toUrlEncoded())
    }

    private fun Map<String, String>.toUrlEncoded(): String {
        return this.entries.joinToString("&") { (key, value) ->
            "${key.urlEncode()}=${value.urlEncode()}"
        }
    }

    fun String.urlEncode(): String {
        val allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.~"
        return buildString {
            this@urlEncode.forEach { char ->
                if (char in allowedChars) {
                    append(char)
                } else {
                    // Encode the character as %XX (hexadecimal)
                    append("%")
                    append(char.code.toByte().toString(16).uppercase().padStart(2, '0'))
                }
            }
        }
    }
}
