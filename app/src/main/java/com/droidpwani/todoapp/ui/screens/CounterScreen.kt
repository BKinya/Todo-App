package com.droidpwani.todoapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun CounterScreen(modifier: Modifier = Modifier){
  var count = 0
  Column(modifier = modifier.fillMaxSize(),
  verticalArrangement = Arrangement.Center,
  horizontalAlignment = Alignment.CenterHorizontally) {

    Text(text = "Count is $count", style = TextStyle(
      fontFamily = FontFamily.Monospace,
      fontSize = 18.sp,

    ))
    Spacer(modifier = Modifier.height(24.dp))
    Button(onClick = {
      count += 1
    }) {
      Text(text = "Click Me!", modifier = modifier.padding(8.dp))
    }
    
  }

}