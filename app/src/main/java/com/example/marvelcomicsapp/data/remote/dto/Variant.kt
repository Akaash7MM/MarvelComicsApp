package com.example.marvelcomicsapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Variant(
    val name: String,
    val resourceURI: String
)