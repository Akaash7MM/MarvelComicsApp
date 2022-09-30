package com.example.data

import android.util.Log
import com.example.data.sources.network.models.ComicsDTO
import com.example.data.util.Constants.API_KEY
import com.example.data.util.Constants.COMICS_URL
import com.example.data.util.Constants.TIME_STAMP
import com.example.data.util.Constants.getURl
import com.example.data.util.Constants.hashGen
import com.example.domain.util.Resource
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
// Using Safe result throws
// kotlinx.serialization.SerializationException: Serializer for class 'Resource' is not found.
// Mark the class as @Serializable or provide the serializer explicitly.
class ComicApiImpl (
    private val client : HttpClient
): ComicApi {
    override suspend fun getComics(): Resource<ComicsDTO> {
        val comicsResult : ComicsDTO = client.get(getURl(COMICS_URL)) {
            try{
                url{
                    //path(COMICS_URL)
                    parameters.apply {
                        append("ts", TIME_STAMP)
                        append("apikey",API_KEY)
                        append("hash", hashGen())
                    }
                }

            }catch (e : Exception){
                Log.d("Caught","In the Failure Block${e.message}")
                return Resource.Failure(e)
            }
        }.body()
       return Resource.Success(comicsResult)
    }

    override suspend fun searchComics(titleStartsWith : String ) : Resource<ComicsDTO> {
        val comicsResult : ComicsDTO = client.get(getURl(COMICS_URL)) {
            try{
                url{
                    //path(COMICS_URL)
                    parameters.apply {
                        append("titleStartsWith",titleStartsWith)
                        append("ts", TIME_STAMP)
                        append("apikey", API_KEY)
                        append("hash", hashGen())
                    }
                }
            } catch (e:Exception){
                return Resource.Failure(e)
            }
        }.body()
        return Resource.Success(comicsResult)
    }
}