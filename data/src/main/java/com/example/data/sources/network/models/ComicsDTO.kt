package com.example.data.sources.network.models

import kotlinx.serialization.Serializable

@Serializable
data class ComicsDTO(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)