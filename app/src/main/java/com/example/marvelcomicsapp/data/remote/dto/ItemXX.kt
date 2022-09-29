package com.example.marvelcomicsapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ItemXX(
    val name: String,
    val resourceURI: String,
    val type: String
)