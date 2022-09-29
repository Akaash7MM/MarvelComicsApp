package com.example.marvelcomicsapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val name: String,
    val resourceURI: String
)