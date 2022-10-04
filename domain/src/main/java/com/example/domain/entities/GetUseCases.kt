package com.example.domain.entities

import com.example.domain.usecases.GetComicsUseCase


data class GetUseCases(
    val getComics: GetComicsUseCase,
    //val getSearch : GetComicsUseCase
)
