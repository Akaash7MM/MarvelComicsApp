package com.example.marvelcomicsapp.ui.presentation.main_screen.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.marvelcomicsapp.ui.presentation.main_screen.ComicDetailBottomSheet
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class,
    DelicateCoroutinesApi::class
)
//how should i name this?
@Composable
fun ComicListComposable(
    comicItemsList:List<Comic>,
    bgState: BackgroundState,
    onClick : (Comic) -> Unit
) {

    val url = bgState.imageUrl
    val title = bgState.title
    val price = bgState.price

    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    val selectionId = remember {
        mutableStateOf(-1)
    }
    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed
    )
    val sheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )

        BottomSheetScaffold(
            scaffoldState = sheetScaffoldState,
            sheetContent = {
                ComicDetailBottomSheet(
                    bgState,
                    sheetState) },
            sheetBackgroundColor = Color.Transparent,
        )  {

            //This in another composable?

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
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = 20.dp),
                        text = title,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 20.dp),
                        text = if(price==0.0) "" else "$$price",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        modifier = Modifier
                            .padding(start = 20.dp,top= 10.dp, bottom = 10.dp),
                        text = "Marvel Comics",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    LazyRow(
                        state = listState,
                        modifier = Modifier
                            .wrapContentHeight()
                            .wrapContentWidth(),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        contentPadding = PaddingValues(start = 0.dp,end = 0.dp,bottom =100.dp)
                    ) {

                        itemsIndexed(comicItemsList) {index,item ->

                                ComicListItem(
                                    item = item,
                                    index = index,
                                    selectionId = selectionId.value,
                                    onClick = {
                                        onClick(item)

                                        coroutineScope.launch {
                                            listState.animateScrollToItem(index)
                                        }

                                        selectionId.value = index
                                    }
                                )

                        }
                    }

                }
            }
        }
    }