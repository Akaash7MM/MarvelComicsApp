package com.example.marvelcomicsapp.ui.presentation.main_screen.components.bottom_sheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TimeLine() {

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier
            .width(46.dp)
            .height(4.dp)
            .background(Color.White))
        Surface(
            modifier = Modifier
                .width(7.dp)
                .height(7.dp)
                .clip(CircleShape),
            color = Color.Gray
        ){
            Row(modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier
                    .width(3.dp)
                    .height(3.dp)
                    .background(Color.Red))
            }
        }

        Box(modifier = Modifier
            .width(46.dp)
            .height(4.dp)
            .background(Color.White))
    }


}
