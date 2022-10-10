package com.example.marvelcomicsapp.ui.presentation.main_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ComicDetailBottomSheet(
    bgState: BackgroundState,
    sheetState:BottomSheetState
) {

    val title = bgState.title
    val pageCount = bgState.pageCount
    val description = bgState.description
    val price = bgState.price


    val sheetProgress = sheetState.rememberBottomSheetProgress()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .shadow(0.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.White, Color.White
                    )
                ), alpha = sheetProgress
            ),
        contentAlignment = Alignment.TopStart
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            Alignment.Start
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                    if (sheetProgress < 0.00001f) {
                        Text(
                            modifier = Modifier,
                            text = "MORE DETAILS",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                        )

                    }

            }
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                text = title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                text = if(pageCount==0) "" else "Page count: ${pageCount}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                text = description,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                text = if(price==0.0) "" else "$$price",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Column(modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {}, shape = RoundedCornerShape(10.dp)) {
                    Text(text = "Buy Now")
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetState.rememberBottomSheetProgress() = remember {
    derivedStateOf {
        val fraction = this.progress.fraction
        val targetValue = this.targetValue
        val currentValue = this.currentValue
        when {
            currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Collapsed -> 0f
            currentValue == BottomSheetValue.Expanded && targetValue == BottomSheetValue.Expanded -> 1f
            currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Expanded -> fraction
            else -> 1f - fraction
        }
    }
}.value




