package com.example.composetutorial.ui.theme.mangeStateApp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items


@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(items = list, key = { task -> task.id }) { task ->
            WellnessTaskItem(taskName = task.label, onClose = { onCloseTask(task) })
        }
    }
}