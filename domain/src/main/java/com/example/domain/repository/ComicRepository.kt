package com.example.domain.repository

import com.example.domain.entities.Comic
import com.example.domain.util.Resource

interface ComicRepository {

    suspend fun getComics() : Resource<List<Comic>>
    suspend fun searchComics(titleStartsWith : String) : Resource<List<Comic>>
}