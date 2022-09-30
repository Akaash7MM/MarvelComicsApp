package com.example.data.sources.network.models

import kotlinx.serialization.Serializable

@Serializable
data class ItemXX(
    val name: String,
    val resourceURI: String,
    val type: String
)