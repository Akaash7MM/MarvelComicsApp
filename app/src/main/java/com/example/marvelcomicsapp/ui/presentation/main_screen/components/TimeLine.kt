package com.example.marvelcomicsapp.ui.presentation.main_screen.components.bottom_sheet

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun TimeLine(
    selectionId :Int,
    index :Int
) {

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier
            .width(58.dp)
            .height(2.dp)
            .background(Color.White))
        Box(
            modifier = Modifier
                .width(14.dp)
                .height(14.dp)
                .background(Color.Transparent)
                .clip(CircleShape)
        ){
            Canvas(modifier = Modifier.fillMaxSize()){
                drawCircle(Color.White,style = Stroke(width = 4.dp.toPx()))
            }
            Row(modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if(selectionId == index){
                    Canvas(modifier = Modifier.fillMaxSize()){
                        drawCircle(Color.White, radius = 3.dp.toPx())
                    }
                }
            }
        }
        Box(modifier = Modifier
            .width(58.dp)
            .height(2.dp)
            .background(Color.White))
    }


}
