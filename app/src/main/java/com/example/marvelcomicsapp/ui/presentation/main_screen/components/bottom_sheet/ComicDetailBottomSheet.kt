package com.example.marvelcomicsapp.ui.presentation.main_screen

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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ComicDetailBottomSheet(
    bgState: BackgroundState,
    sheetState:BottomSheetState
) {


    val url = bgState.imageUrl
    val title = bgState.title
    val pageCount = bgState.pageCount
    val description = bgState.description
    val price = bgState.price
    val sheetIsCollapsed = sheetState.isCollapsed
    val openedFraction  = sheetState.progress.fraction

    val sheetBGAlpha = sheetState.rememberBottomSheetProgress()

//
//    val sheetBGAlpha =
//        if(openedFraction.equals(1.0f) && sheetIsCollapsed){
//        0.0f
//    }
//    else if(openedFraction.equals(1.0f) && !sheetIsCollapsed){
//        1.0f
//    }
//    else if(!openedFraction.equals(1.0f) && sheetIsCollapsed){
//        openedFraction
//    }
//    else if(!openedFraction.equals(1.0f) && !sheetIsCollapsed){
//        1.0f-openedFraction
//    } else {
//        1.0f
//    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(20.dp))
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.Black, Color.Black
                    )
                ), alpha = sheetBGAlpha
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
                .wrapContentWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (sheetIsCollapsed && openedFraction.equals(1.0f)) {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 20.dp),
                        text = "More Details",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
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
                color = Color.White
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                text = if(pageCount==0) "" else "Page count: ${pageCount}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                text = description,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                text = "$$price",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
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

@Preview
@Composable
fun sheetPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(20.dp))
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.Black, Color.Black
                    )
                ), alpha = 0.8f
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
                    .wrapContentWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (true) {
                        Text(
                            modifier = Modifier
                                .padding(horizontal = 20.dp, vertical = 10.dp),
                            text = "More Details",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
                Text(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    text = "Title",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    text = "Page Count",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    text = "DescriptionDescriDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionptionDescriptionDescriptionDescriptionDescriptionDescriptionDescription",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    text = "Price",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Button(onClick = {

                }, shape = RoundedCornerShape(20.dp)) {
                Text(text = "Buy Now")
            }
            }
        }

    }




