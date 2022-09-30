package com.example.data.sources.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val extension: String,
    val path: String
)