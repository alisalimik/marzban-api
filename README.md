# Marzban V2ray Panel Kotlin Multiplatform Library

This library provides a Kotlin multiplatform API for interacting with Marzban V2ray panel. It supports both JVM and Native targets, allowing you to interact with the Marzban API from your Kotlin applications on various platforms.

## Features

- **Comprehensive API coverage**: This library offers a wide range of API endpoints for managing users, nodes, subscriptions, system settings, and more.
- **Multiplatform Support**: Works on both JVM and JS targets, allowing you to use it in your Android, Desktop, or Web applications.
- **Easy to Use**: Simple and intuitive API for interacting with the Marzban panel.
- **Type-Safe and Kotlin-First**: Leverages Kotlin's type system and idioms to provide a safe and efficient development experience.

## Getting Started

### Add Dependency
Add the library to your project's dependencies.

### Initialize Configuration
Create a `MarzbanConfig` object with your Marzban panel URL and optional authentication token.

### Use API Endpoints
Use the provided API endpoints to interact with the Marzban panel.

## Example Usage

```kotlin
import io.github.alisalimik.marzban.Client
import io.github.alisalimik.marzban.MarzbanConfig
import io.github.alisalimik.marzban.api.User
import kotlinx.coroutines.runBlocking

fun main() {
    // Initialize MarzbanConfig
    val marzbanConfig = MarzbanConfig(
        url = "https://your-marzban-panel.com",
        token = "your-auth-token"
    )
    Client.initConfig(marzbanConfig)

    // Get user information
    runBlocking {
        val result = User.get(username = "your-username")
        when (result) {
            is ApiResult.Success -> {
                println("User Information: ${result.data}")
            }
            is ApiResult.ErrorResponse -> {
                println("Error: ${result.response}")
            }
            is ApiResult.Error -> {
                println("Error: ${result.exception.message}")
            }
        }
    }
}
