package com.example.data.repository

import com.example.data.ComicApi
import com.example.data.sources.network.models.toComic
import com.example.domain.entities.Comic
import com.example.domain.repository.ComicRepository
import com.example.domain.util.Resource

class ComicsRepositoryImpl(
    val api : ComicApi
) : ComicRepository {

    override suspend fun getComics() : Resource<List<Comic>> {

        val result = api.getComics()



        when(result){
            is Resource.Success -> {
                val list =  result.result.data.results.map { it.toComic() }
                return Resource.Success(list)
            }
            is Resource.Failure -> {
                //Deal with DB?
                return result
            }
        }
       // return NetworkState.Failure(message = "no source active")
    }

    override suspend fun searchComics(titleStartsWith: String) : Resource<List<Comic>> {
        val result = api.searchComics(titleStartsWith)

        when(result){
            is Resource.Success -> {
                val list =  result.result.data.results.map { it.toComic() }
                return Resource.Success(list)
            }
            is Resource.Failure -> {
                //Deal with DB?
                return result
            }
        }
       // return NetworkState.Failure(message = "no source active")
    }
}