package com.droidpwani.todoapp.ui.components

import android.util.Log

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun CounterComponent(modifier: Modifier = Modifier){
  val count = rememberSaveable{ mutableStateOf(0)}
  Log.d("COUNT", "ALL of it")
  Column(modifier = modifier.fillMaxSize(),
  verticalArrangement = Arrangement.Center,
  horizontalAlignment = Alignment.CenterHorizontally) {
    Log.d("COUNT", "Just the column")

    Box {
      Log.d("COUNT", "Just the text")
      Text(
        text = "Count is ${count.value}", style = TextStyle(
          fontFamily = FontFamily.Monospace,
          fontSize = 18.sp,

          )
      )
    }
    Spacer(modifier = Modifier.height(24.dp))
    Box {
      Log.d("COUNT", "Just the Button")
      Button(onClick = {
        count.value += 1
        Log.d("COUNT", "is ${count.value}")
      }) {
        Text(text = "Click Me!", modifier = modifier.padding(8.dp))
      }
    }
  }

}

