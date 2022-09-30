package com.example.data.sources.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Variant(
    val name: String,
    val resourceURI: String
)