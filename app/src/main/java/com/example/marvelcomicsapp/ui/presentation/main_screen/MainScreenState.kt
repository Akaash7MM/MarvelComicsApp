package com.example.marvelcomicsapp.ui.presentation.main_screen

import com.example.marvelcomicsapp.domain.model.Comic

data class MainScreenState(
    val list:List<Comic> = emptyList(),
    val data:Boolean = false,
    val message:String = "Error occured"
)
