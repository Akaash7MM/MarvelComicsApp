package com.example.data.sources.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: Int
)