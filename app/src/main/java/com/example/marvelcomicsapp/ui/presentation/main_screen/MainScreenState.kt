package com.example.marvelcomicsapp.ui.presentation.main_screen

sealed class MainScreenState<out T>{
    object Empty : MainScreenState<Nothing>()
    object Loading:MainScreenState<Nothing>()
    class  Failure(val throwable: Throwable):MainScreenState<Nothing>()
    class Success<T>(val data : T): MainScreenState<T>()
}
