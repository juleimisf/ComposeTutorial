package com.example.composetutorial.ui.theme.mangeStateApp

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {

        Text(
            modifier = modifier
                .weight(1f)
                .padding(start = 16.dp), text = taskName
        )

        Checkbox(checked = checked, onCheckedChange = onCheckedChange)

        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")

        }
    }
}

@Composable
fun WellnessTaskItem(
    modifier: Modifier = Modifier,
    taskName: String,
    onClose: () -> Unit
) {
    var checkedState by rememberSaveable { mutableStateOf(false) }

    WellnessTaskItem(
        taskName = taskName,
        checked = checkedState,
        onCheckedChange = { newValue -> checkedState = newValue },
        onClose =  onClose , // we will implement this later!
        modifier = modifier,
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
private fun WellnessTaskItemPreview() {
    ComposeTutorialTheme() {
        WellnessTaskItem("This is a task!", false, {}, {})
    }
}