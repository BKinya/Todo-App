package com.droidpwani.todoapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidpwani.todoapp.LogCompositions
import com.droidpwani.todoapp.TAG
import com.droidpwani.todoapp.ui.screens.TodoScreen

/**
 * TODO
 * If count is greater then 10 show Text below `click me!` button
 *
 */


@Composable
fun CounterScreen(modifier: Modifier = Modifier, count: Int, updateCount: () -> Unit) {
  LogCompositions(tag = TAG, msg = "CounterScreen")
  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(16.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {

    Text(
      text = "Count is $count", style = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontSize = 18.sp,

        )
    )
    Spacer(modifier = Modifier.height(24.dp))
    Button(onClick = updateCount) {
      Text(text = "Click Me!", modifier = modifier.padding(8.dp))
    }

  }

}

