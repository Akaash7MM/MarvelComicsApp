package com.example.marvelcomicsapp.ui.presentation.main_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.entities.Comic

// Cards wraps Content -> size declared image OK
// Card size declared -> image fillmaxsize()
//
@Composable
fun ComicListItem(
    item : Comic,
    onClick : () ->Unit
) {
    Card(modifier = Modifier
        .scale(0.5f)
        .clip(RoundedCornerShape(10.dp))
        .padding(10.dp)
        .clickable {
            onClick()
        }
    ){
        AsyncImage(
            modifier = Modifier,
            model = item.imageURL,
            contentDescription = null )

      /*  Column(modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
        }*/


    }
}