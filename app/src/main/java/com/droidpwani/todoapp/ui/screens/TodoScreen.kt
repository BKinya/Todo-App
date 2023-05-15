package com.droidpwani.todoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidpwani.todoapp.LogCompositions
import com.droidpwani.todoapp.R
import com.droidpwani.todoapp.TAG
import com.droidpwani.todoapp.todoItem
import com.droidpwani.todoapp.todoItem2
import com.droidpwani.todoapp.ui.components.TodoItemComponent

@Composable
fun TodoScreen(
  modifier: Modifier = Modifier,
) {
  val item = remember { mutableStateOf(todoItem) }
  val item2 = remember { mutableStateOf(todoItem2) }
  LogCompositions(tag = TAG, msg = "TodoScreen")
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(20.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Text(
      text = "My ability to turn good news into anxiety is rivaled only " +
          "by my ability to turn anxiety into chin acne. IYKYK",
      style = TextStyle(
        fontSize = 18.sp,
        fontFamily = FontFamily.Monospace,
        textAlign = TextAlign.Center
      )
    )

    TodoItemComponent(
      modifier = modifier,
      item = item.value,
      updateItem = {
        val oldItem = item.value
        item.value = oldItem.copy(done = !oldItem.done)
      }
    )

    TodoItemComponent(
      modifier = modifier,
      item = item2.value,
      updateItem = {
        val oldItem = item2.value
        item2.value = oldItem.copy(done = !oldItem.done)
      }
    )

    Image(modifier = modifier.align(Alignment.CenterHorizontally),
      painter = painterResource(id = R.drawable.logo), contentDescription ="logo")


  }
}

