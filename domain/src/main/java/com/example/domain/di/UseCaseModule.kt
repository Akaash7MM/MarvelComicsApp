package com.example.domain.di

import com.example.domain.entities.GetUseCases
import com.example.domain.repository.ComicRepository
import com.example.domain.usecases.GetComicsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCases(repository: ComicRepository) : GetUseCases {
        return GetUseCases(
            getComics = GetComicsUseCase(repository)
        )
    }
/*
    @Provides
    @Singleton
    fun provideGetComicsUseCase(repository: ComicRepository):GetComicsUseCase{
        return GetComicsUseCase(repository =repository )
    }

 */
}
