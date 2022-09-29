package com.example.marvelcomicsapp.di

import com.example.marvelcomicsapp.data.remote.ComicApiImpl
import com.example.marvelcomicsapp.data.remote.ComicsRepositoryImpl
import com.example.marvelcomicsapp.domain.ComicApi
import com.example.marvelcomicsapp.domain.repository.ComicRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesComicsApi() : ComicApi {
        return ComicApiImpl(
            client = HttpClient(Android){
                install(Logging){
                    level = LogLevel.ALL
                }
                install(ContentNegotiation){
                    json(Json{
                        prettyPrint = true
                        isLenient = true
                        coerceInputValues = true
                        ignoreUnknownKeys = true
                        encodeDefaults = true
                        //explicitNulls = true
                    })
                }
            }
        )
    }

    @Provides
    @Singleton
    fun providesComicRepository(api: ComicApi) : ComicRepository{
        return ComicsRepositoryImpl(api)
    }
}