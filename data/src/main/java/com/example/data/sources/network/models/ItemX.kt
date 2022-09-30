package com.example.data.sources.network.models

import kotlinx.serialization.Serializable

@Serializable
data class ItemX(
    val name: String,
    val resourceURI: String,
    val role: String
)