package com.example.marvelcomicsapp.data.remote

import com.example.marvelcomicsapp.Common.Constants
import com.example.marvelcomicsapp.Common.Constants.COMICS_URL
import com.example.marvelcomicsapp.Common.Constants.getURl
import com.example.marvelcomicsapp.Common.NetworkState
import com.example.marvelcomicsapp.data.remote.dto.ComicsDTO
import com.example.marvelcomicsapp.domain.ComicApi
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ComicApiImpl (
    private val client : HttpClient
): ComicApi {
    override suspend fun getComics(): NetworkState<ComicsDTO> {
        val comicsResult : ComicsDTO = client.get(Constants.getURl(COMICS_URL)) {
            try{
                url{
                    //path(COMICS_URL)
                    parameters.apply {
                        append("ts", Constants.TIME_STAMP)
                        append("apikey", Constants.API_KEY)
                        append("hash", Constants.hashGen())
                    }
                }

            }catch (e : Exception){
                return NetworkState.Failure(e)
            }
        }.body()
       return NetworkState.Success(comicsResult)
    }

    override suspend fun searchComics(titleStartsWith : String ) : NetworkState<ComicsDTO> {
        val comicsResult : ComicsDTO = client.get(getURl(COMICS_URL)) {
            try{
                url{
                    //path(COMICS_URL)
                    parameters.apply {
                        append("titleStartsWith",titleStartsWith)
                        append("ts", Constants.TIME_STAMP)
                        append("apikey", Constants.API_KEY)
                        append("hash", Constants.hashGen())
                    }
                }
            } catch (e:Exception){
                return NetworkState.Failure(e)
            }
        }.body()
        return NetworkState.Success(comicsResult)
    }
}