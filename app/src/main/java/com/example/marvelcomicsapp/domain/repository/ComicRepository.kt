package com.example.marvelcomicsapp.domain.repository

import com.example.marvelcomicsapp.Common.NetworkState
import com.example.marvelcomicsapp.domain.model.Comic

interface ComicRepository {

    suspend fun getComics() : NetworkState<List<Comic>>
    suspend fun searchComics(titleStartsWith : String) : NetworkState<List<Comic>>
}