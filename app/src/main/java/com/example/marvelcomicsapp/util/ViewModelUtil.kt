package com.example.marvelcomicsapp.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun ViewModel.ioScope(dispatcher: CoroutineDispatcher = Dispatchers.IO, block: suspend () -> Unit) =
    this.viewModelScope.launch(dispatcher) {
        block()
    }