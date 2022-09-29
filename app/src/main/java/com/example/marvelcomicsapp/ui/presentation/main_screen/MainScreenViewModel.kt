package com.example.marvelcomicsapp.ui.presentation.main_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcomicsapp.Common.NetworkState
import com.example.marvelcomicsapp.domain.repository.ComicRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: ComicRepository
):ViewModel() {

    private val mainScreenState = mutableStateOf(MainScreenState())
    val _mainScreenState : State<MainScreenState> = mainScreenState

    init {
        viewModelScope.launch {
            val response = repository.getComics()

            when(response){
                is NetworkState.Success ->{
                    mainScreenState.value= _mainScreenState.value.copy(
                        list = response.result,
                        data = false
                    )
                }
                is NetworkState.Failure ->{
                    mainScreenState.value= _mainScreenState.value.copy(
                        data = false,
                        message = response.message
                    )
                }
            }
        }
    }


}