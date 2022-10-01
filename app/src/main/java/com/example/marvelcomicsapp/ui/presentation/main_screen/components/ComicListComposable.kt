package com.example.marvelcomicsapp.ui.presentation.main_screen.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.domain.entities.Comic

@Composable
fun ComicListComposable(
    comicItemsList:List<Comic>
) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
    ){
        items(comicItemsList){    item ->
            ComicListItem(item = item)
        }
    }
}