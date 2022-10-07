package com.example.marvelcomicsapp.ui.presentation.main_screen.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class,
    DelicateCoroutinesApi::class
)
@Composable
fun ComicListComposable(
    comicItemsList:List<Comic>,
    bgState: BackgroundState,
    onClick : (Comic) -> Unit
) {

    val url = bgState.imageUrl
    val title = bgState.title
    val pageCount = bgState.pageCount
    val price = bgState.price
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
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
                            .padding(horizontal = 20.dp),
                        text = title,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 20.dp),
                        text = "$$price",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(80.dp))
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 20.dp),
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
                        contentPadding = PaddingValues(start = 10.dp, bottom =150.dp, end = 10.dp)
                    ) {

                        itemsIndexed(comicItemsList) {index,item ->

                                ComicListItem(
                                    item = item,
                                    onClick = {
                                        onClick(item)
                                        coroutineScope.launch {
                                            listState.animateScrollToItem(index)
                                        }
                                    }
                                )

                        }
                    }

                }
            }
        }
    }