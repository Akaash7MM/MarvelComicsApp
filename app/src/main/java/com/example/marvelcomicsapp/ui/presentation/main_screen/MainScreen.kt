package com.example.marvelcomicsapp.ui.presentation.main_screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.marvelcomicsapp.ui.presentation.main_screen.components.ComicListComposable
import com.example.marvelcomicsapp.ui.presentation.main_screen.components.GenericFailureScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen(
    mainScreenViewModel: MainScreenViewModel = hiltViewModel()
) {
    val uiState = mainScreenViewModel.screenState

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.LightGray
    ) {
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            AnimatedContent(targetState = uiState) { dataState ->
                when(dataState){
                    is MainScreenState.Empty -> Unit
                    is MainScreenState.Loading -> CircularProgressIndicator()
                    is MainScreenState.Failure -> GenericFailureScreen(throwable = dataState.throwable)
                    is MainScreenState.Success -> ComicListComposable(comicItemsList = dataState.data)
                }

            }
        }
    }

}