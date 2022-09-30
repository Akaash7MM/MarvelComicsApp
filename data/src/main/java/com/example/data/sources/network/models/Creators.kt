package com.example.data.sources.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)