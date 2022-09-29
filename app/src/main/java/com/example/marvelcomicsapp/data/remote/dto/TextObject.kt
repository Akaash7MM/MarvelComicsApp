package com.example.marvelcomicsapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TextObject(
    val language: String,
    val text: String,
    val type: String
)