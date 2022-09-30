package com.example.data.sources.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Url(
    val type: String,
    val url: String
)