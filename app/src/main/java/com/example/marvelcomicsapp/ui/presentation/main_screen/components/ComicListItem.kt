package com.example.marvelcomicsapp.ui.presentation.main_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.entities.Comic
import com.example.marvelcomicsapp.ui.presentation.main_screen.components.bottom_sheet.TimeLine

@Composable
fun ComicListItem(
    item : Comic,
    index : Int,
    selectionId : Int,
    onClick : () ->Unit
) {
    Column {
        Card(modifier = Modifier
            .padding(15.dp)
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
        Spacer(modifier = Modifier.height(5.dp))
        TimeLine(index = index,selectionId = selectionId)
    }
}