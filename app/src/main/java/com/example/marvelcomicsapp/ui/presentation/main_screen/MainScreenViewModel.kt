package com.example.marvelcomicsapp.ui.presentation.main_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.GetUseCases
import com.example.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val useCases: GetUseCases
):ViewModel() {

    //UiState Pending

    private val mainScreenState = mutableStateOf(MainScreenState())
    val _mainScreenState : State<MainScreenState> = mainScreenState

    init {
        viewModelScope.launch {
            val response = useCases.getComics.invoke()

            when(response){
                is Resource.Success ->{
                    Log.d("Caught","In the Success Block")

                    mainScreenState.value= _mainScreenState.value.copy(
                        list = response.result,
                        data = true
                    )
                }
                is Resource.Failure ->{
                    Log.d("Caught","In the Failure Block")
                    mainScreenState.value= _mainScreenState.value.copy(
                        data = false,
                        message = "response.message"
                    )
                }
            }
        }
    }


}