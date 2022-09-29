package com.example.marvelcomicsapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)