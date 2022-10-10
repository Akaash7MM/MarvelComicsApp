package com.example.marvelcomicsapp.ui.presentation.main_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.marvelcomicsapp.ui.presentation.main_screen.components.ComicListComposable
import com.example.marvelcomicsapp.ui.presentation.main_screen.components.GenericFailureScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen(
    mainScreenViewModel: MainScreenViewModel = hiltViewModel()
) {
    val uiState = mainScreenViewModel.screenState
    val backgroundState = mainScreenViewModel.backgroundState.value

    val systemUiController = rememberSystemUiController()

    SideEffect() {
        systemUiController.setSystemBarsColor(Color.Black)
        // systemUiController.isSystemBarsVisible
    }

    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        AnimatedContent(targetState = uiState) { dataState ->
            when(dataState){
                is MainScreenState.Empty -> Unit
                is MainScreenState.Loading -> CircularProgressIndicator()
                is MainScreenState.Failure -> GenericFailureScreen(throwable = dataState.throwable)
                is MainScreenState.Success -> ComicListComposable(
                    comicItemsList = dataState.data,
                    bgState = backgroundState,
                    onClick = { comicItem ->
                        mainScreenViewModel.setBGdetails(comicItem)
                    }
                )
            }

        }
    }


}