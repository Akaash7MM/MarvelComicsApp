package com.example.domain.usecases

import com.example.domain.repository.ComicRepository

class GetComicsUseCase(
    private val repository: ComicRepository
    ) {

    suspend operator fun invoke() = repository.getComics()

}