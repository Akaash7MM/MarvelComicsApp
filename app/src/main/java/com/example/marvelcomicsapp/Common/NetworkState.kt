package com.example.marvelcomicsapp.Common

sealed class NetworkState<out T> {
    class Success<T>(val result : T) : NetworkState<T>()
    class Failure(
        val exception: Exception? = Exception("Unknown Error"),
        val message: String = exception?.localizedMessage ?: "First"
    ) : NetworkState<Nothing>()
}