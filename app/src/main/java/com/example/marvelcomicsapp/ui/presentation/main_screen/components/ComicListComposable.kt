package com.example.marvelcomicsapp.ui.presentation.main_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.entities.Comic

@Composable
fun ComicListComposable(
    comicItemsList:List<Comic>
) {
    LazyRow(modifier = Modifier
        .fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center,
        contentPadding = PaddingValues(20.dp)
    ){
        items(comicItemsList){    item ->
            ComicListItem(item = item)
        }
    }
}