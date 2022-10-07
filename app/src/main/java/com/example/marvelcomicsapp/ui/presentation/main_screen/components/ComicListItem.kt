package com.example.marvelcomicsapp.ui.presentation.main_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.entities.Comic
import com.example.marvelcomicsapp.ui.presentation.main_screen.components.bottom_sheet.TimeLine

// Cards wraps Content -> size declared image OK
// Card size declared -> image fillmaxsize()
//
@Composable
fun ComicListItem(
    item : Comic,
    onClick : () ->Unit
) {
    Column {
        Card(modifier = Modifier
            .clickable {
                onClick()
            }
        ){
            AsyncImage(
                modifier = Modifier
                    .size(98.dp,150.dp),
                model = item.imageURL,
                contentDescription = null )
        }
        Spacer(modifier = Modifier.height(10.dp))
        TimeLine()
    }
}