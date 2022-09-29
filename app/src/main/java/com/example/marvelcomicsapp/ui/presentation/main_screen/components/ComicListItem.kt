package com.example.marvelcomicsapp.ui.presentation.main_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.marvelcomicsapp.domain.model.Comic

@Composable
fun ComicListItem(
    item : Comic
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .clip(RoundedCornerShape(10.dp))
        .padding(10.dp)
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            ) {
                Text(
                    modifier = Modifier
                        .padding(10.dp),
                    text = item.title,
                    style = TextStyle(
                        fontSize = 24.sp
                    ),

                )

        }


    }
}