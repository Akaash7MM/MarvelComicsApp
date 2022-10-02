package com.example.marvelcomicsapp.ui.presentation.main_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.entities.Comic

@Composable
fun ComicListItem(
    item : Comic,
    onClick : () ->Unit
) {
    Card(modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight()
        .clip(RoundedCornerShape(10.dp))
        .padding(10.dp)
    ){
        Column(modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AsyncImage(
                    modifier = Modifier
                        .clickable {
                            onClick()
                        },
                    model = item.imageURL,
                    contentDescription = null )
        }


    }
}