package com.example.data.sources.network.models

import kotlinx.serialization.Serializable

@Serializable
data class TextObject(
    val language: String,
    val text: String,
    val type: String
)