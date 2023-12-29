package com.example.mvvm_room_coroutines.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvm_room_coroutines.ConvertViewModel
import com.example.mvvm_room_coroutines.ConverterViewModelFactory
import com.example.mvvm_room_coroutines.compose.converter.TopScreen
import com.example.mvvm_room_coroutines.compose.history.HistoryScreen

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    convertViewModel: ConvertViewModel = viewModel(factory = factory)
) {
    val list = convertViewModel.getConversions()
    val historyList = convertViewModel.resultList.collectAsState(initial = emptyList())


    Column(modifier = modifier.padding(30.dp)) {
        TopScreen(list) { message1, messeage2 ->
            convertViewModel.addResult(message1, messeage2)
        }

        Spacer(modifier = modifier.height(20.dp))

        HistoryScreen(historyList, { item ->
            convertViewModel.removeResult(item)
        })
    }
}