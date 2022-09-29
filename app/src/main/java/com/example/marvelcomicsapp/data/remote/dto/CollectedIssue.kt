package com.example.marvelcomicsapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CollectedIssue(
    val name: String,
    val resourceURI: String
)