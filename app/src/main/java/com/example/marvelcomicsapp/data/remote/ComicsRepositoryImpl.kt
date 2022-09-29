package com.example.marvelcomicsapp.data.remote

import com.example.marvelcomicsapp.Common.NetworkState
import com.example.marvelcomicsapp.data.remote.dto.toComic
import com.example.marvelcomicsapp.domain.ComicApi
import com.example.marvelcomicsapp.domain.model.Comic
import com.example.marvelcomicsapp.domain.repository.ComicRepository

class ComicsRepositoryImpl(
    val api : ComicApi
) : ComicRepository {

    override suspend fun getComics() : NetworkState<List<Comic>> {

        val result = api.getComics()

        when(result){
            is NetworkState.Success -> {
                val list =  result.result.data.results.map { it.toComic() }
                return NetworkState.Success(list)
            }
            is NetworkState.Failure -> {
                //Deal with DB?
                return result
            }
        }
       // return NetworkState.Failure(message = "no source active")
    }

    override suspend fun searchComics(titleStartsWith: String) : NetworkState<List<Comic>> {
        val result = api.searchComics(titleStartsWith)

        when(result){
            is NetworkState.Success -> {
                val list =  result.result.data.results.map { it.toComic() }
                return NetworkState.Success(list)
            }
            is NetworkState.Failure -> {
                //Deal with DB?
                return result
            }
        }
       // return NetworkState.Failure(message = "no source active")
    }
}