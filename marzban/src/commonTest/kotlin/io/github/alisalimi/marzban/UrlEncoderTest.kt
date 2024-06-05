package io.github.alisalimi.marzban

import io.github.alisalimik.marzban.UrlEncoder.setForm
import io.github.alisalimik.marzban.UrlEncoder.urlEncode
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.utils.io.core.toByteArray
import kotlin.test.Test
import kotlin.test.assertEquals

class UrlEncoderTest {
    @Test
    fun `test form encoding`() {
        val body =
            mapOf(
                "key1" to "value1",
                "key2" to "value with spaces",
                "key3" to "value with special chars: &+",
            )
        val expectedEncodedBody = "key1=value1&key2=value%20with%20spaces&key3=value%20with%20special%20chars%3A%20%26%2B"

        val builder = HttpRequestBuilder()
        builder.setForm(body)

        assertEquals(expectedEncodedBody, (builder.body as String).toByteArray().decodeToString())
    }

    @Test
    fun `test url encoding`() {
        val testCases =
            mapOf(
                "hello world" to "hello%20world",
                "hello%world" to "hello%25world",
                "hello+world" to "hello%2Bworld",
                "hello&world" to "hello%26world",
                "hello/world" to "hello%2Fworld",
                "hello?world" to "hello%3Fworld",
                "hello#world" to "hello%23world",
                "hello@world" to "hello%40world",
                "hello[world]" to "hello%5Bworld%5D",
                "hello{world}" to "hello%7Bworld%7D",
                "hello|world" to "hello%7Cworld",
                "hello^world" to "hello%5Eworld",
                "hello~world" to "hello~world",
                "hello`world" to "hello%60world",
                "hello\"world" to "hello%22world",
                "hello'world" to "hello%27world",
                "hello\\world" to "hello%5Cworld",
                "hello;world" to "hello%3Bworld",
                "hello:world" to "hello%3Aworld",
                "hello<world>" to "hello%3Cworld%3E",
                "hello>world" to "hello%3Eworld",
                "hello=world" to "hello%3Dworld",
            )

        testCases.forEach { (input, expected) ->
            assertEquals(expected, input.urlEncode(), "Encoding failed for input: '$input'")
        }
    }
}
