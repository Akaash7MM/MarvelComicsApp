package com.example.data.sources.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)