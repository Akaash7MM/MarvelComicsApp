package com.example.data.sources.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)