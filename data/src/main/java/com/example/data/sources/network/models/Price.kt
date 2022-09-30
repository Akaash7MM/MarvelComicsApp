package com.example.data.sources.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Price(
    val price: Double,
    val type: String
)