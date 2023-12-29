package com.example.mvvm_room_coroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_room_coroutines.data.ConverterRepository

class ConverterViewModelFactory(
    private val repo: ConverterRepository,
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ConvertViewModel(repo) as T
    }
}