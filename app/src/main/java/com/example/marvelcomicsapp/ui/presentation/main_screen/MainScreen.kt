package com.example.marvelcomicsapp.ui.presentation.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.marvelcomicsapp.ui.presentation.main_screen.components.ComicListItem

@Composable
fun MainScreen(
    mainScreenViewModel: MainScreenViewModel = hiltViewModel()
) {
    val list = mainScreenViewModel._mainScreenState.value.list
    val data = mainScreenViewModel._mainScreenState.value.data
    val message = mainScreenViewModel._mainScreenState.value.message

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.LightGray,
    ) {
        if(data){
            LazyColumn(modifier = Modifier
                .fillMaxSize()
            ){
                items(list){    item ->
                    ComicListItem(item = item)
                }
            }
        }
        else{
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier,
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.Black
                    ),
                    text = message )
            }
        }

    }

}