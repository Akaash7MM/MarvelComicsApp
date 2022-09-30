package com.example.data.sources.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Date(
    val date: String,
    val type: String
)