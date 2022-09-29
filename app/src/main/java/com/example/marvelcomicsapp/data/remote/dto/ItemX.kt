package com.example.marvelcomicsapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ItemX(
    val name: String,
    val resourceURI: String,
    val role: String
)