package com.example.marvelcomicsapp.ui.presentation.main_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.domain.entities.Comic
import com.example.domain.entities.GetUseCases
import com.example.domain.util.Resource
import com.example.marvelcomicsapp.util.ioScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val useCases: GetUseCases
):ViewModel() {

    var screenState: MainScreenState<List<Comic>> by mutableStateOf(MainScreenState.Empty)
        private set

    init {
        screenState = MainScreenState.Loading

        ioScope {
            val response = useCases.getComics()
            when (response) {
                is Resource.Failure -> {
                    screenState = MainScreenState.Failure(response.throwable)
                }
                is Resource.Success -> {
                    screenState = MainScreenState.Success(response.result)
                }
            }

        }
    }
}