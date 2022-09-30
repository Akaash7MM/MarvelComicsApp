package com.example.marvelcomicsapp.ui.presentation.main_screen

data class MainScreenState(
    val list:List<com.example.domain.entities.Comic> = emptyList(),
    val data:Boolean = false,
    val message:String = "Error occured, this is in state"
)
