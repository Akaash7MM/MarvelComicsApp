package com.example.marvelcomicsapp.ui.presentation.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.Black, Color.Gray
                    )
                ), alpha = 0.3f
            )
        )
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                text = "Marvel Comics",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            LazyRow(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center,
                contentPadding = PaddingValues(start = 10.dp, bottom =20.dp, end = 10.dp)
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
}