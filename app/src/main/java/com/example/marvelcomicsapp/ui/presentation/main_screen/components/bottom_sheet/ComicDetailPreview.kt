package com.example.marvelcomicsapp.ui.presentation.main_screen.components.bottom_sheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ComicDetailPreview() {
    Column(modifier  =Modifier
        .fillMaxSize()

    ) {
        Text(
            text="More Details"
        )
    }
}