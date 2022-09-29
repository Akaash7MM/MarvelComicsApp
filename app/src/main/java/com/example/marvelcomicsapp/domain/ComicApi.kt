package com.example.marvelcomicsapp.domain

//import io.ktor.client.features.json.*
//import io.ktor.client.features.json.serializer.*
//import io.ktor.client.features.logging.*
//import io.ktor.client.plugins.kotlinx.serializer.*
import com.example.marvelcomicsapp.Common.NetworkState
import com.example.marvelcomicsapp.data.remote.dto.ComicsDTO

interface ComicApi {

    suspend fun getComics(): NetworkState<ComicsDTO>

    suspend fun searchComics(titleStartsWith:String ): NetworkState<ComicsDTO>

}