package com.example.marvelcomicsapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)