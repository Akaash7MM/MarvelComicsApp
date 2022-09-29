package com.example.marvelcomicsapp.data.remote.dto

import com.example.marvelcomicsapp.domain.model.Comic
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val characters: Characters,
    val collectedIssues: List<CollectedIssue>,
   // val collections: List<Any>,
    val creators: Creators,
    val dates: List<Date>,
    val description: String ="",
    val diamondCode: String,
    val digitalId: Int,
    val ean: String,
   // val events: Events,
    val format: String,
    val id: Int,
    val images: List<Image>,
    val isbn: String,
    val issn: String,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val prices: List<Price>,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val textObjects: List<TextObject>,
    val thumbnail: Thumbnail,
    val title: String,
    val upc: String,
    val urls: List<Url>,
    val variantDescription: String,
    val variants: List<Variant>
)

fun Result.toComic (): Comic {
    return Comic(
        title = title,
        pageCount = pageCount,
        description = description,
        imageURL = thumbnail.path + thumbnail.extension
    )
}