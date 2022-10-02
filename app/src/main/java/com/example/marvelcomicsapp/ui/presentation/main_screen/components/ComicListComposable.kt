package com.example.marvelcomicsapp.ui.presentation.main_screen.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.entities.Comic
import com.example.marvelcomicsapp.ui.presentation.main_screen.BackgroundState

@Composable
fun ComicListComposable(
    comicItemsList:List<Comic>,
    bgState: BackgroundState,
    onClick : (String) -> Unit
) {

    val url = bgState.imageUrl

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Black
    ) {
        AsyncImage(
            model = url,
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        LazyRow(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
            contentPadding = PaddingValues(20.dp)
        ) {
            items(comicItemsList) { item ->
                ComicListItem(
                    item = item,
                    onClick = {
                        onClick(item.imageURL)
                    }
                )
            }
        }
    }
}