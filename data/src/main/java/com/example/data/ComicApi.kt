package com.example.data

import com.example.data.sources.network.models.ComicsDTO
import com.example.domain.util.Resource

//import io.ktor.client.features.json.*
//import io.ktor.client.features.json.serializer.*
//import io.ktor.client.features.logging.*
//import io.ktor.client.plugins.kotlinx.serializer.*

interface ComicApi {

    suspend fun getComics(): Resource<ComicsDTO>

    suspend fun searchComics(titleStartsWith:String ): Resource<ComicsDTO>

}