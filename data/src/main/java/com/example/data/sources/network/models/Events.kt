package com.example.data.sources.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Events(
    val available: Int,
    val collectionURI: String,
    //val items: List<Any>,
    val returned: Int
)