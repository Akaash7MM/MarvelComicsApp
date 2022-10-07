package com.example.data

import com.example.data.sources.network.models.ComicsDTO
import com.example.domain.util.Resource



interface ComicApi {

    suspend fun getComics(): Resource<ComicsDTO>

    suspend fun searchComics(titleStartsWith:String ): Resource<ComicsDTO>

}