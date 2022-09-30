package com.example.data.sources.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Series(
    val name: String,
    val resourceURI: String
)