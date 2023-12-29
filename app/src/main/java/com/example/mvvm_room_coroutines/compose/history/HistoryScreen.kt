package com.example.mvvm_room_coroutines.compose.history

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.example.mvvm_room_coroutines.data.ConversionResult

@Composable
fun HistoryScreen(
    list: State<List<ConversionResult>>,
    onCloseTask: (ConversionResult) -> Unit,
    modifier: Modifier = Modifier
) {
    HistoryList(
        list = list,
        onCloseTask = { item ->
            onCloseTask(item)
        }
    )
}