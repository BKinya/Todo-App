package com.droidpwani.todoapp.presentation.component

import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ProgressIndicator() {
    LinearProgressIndicator(
        color = Color.LightGray
    )
}
