package com.example.data.sources.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val name: String,
    val resourceURI: String
)