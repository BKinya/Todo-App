package com.droidpwani.todoapp.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidpwani.todoapp.LogCompositions
import com.droidpwani.todoapp.TodoItem

@Preview
@Composable
fun TodoItemComponent(
  modifier: Modifier = Modifier,
  item: TodoItem = TodoItem(),
  updateItem: () -> Unit = {}
) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(20.dp),
    elevation = CardDefaults.cardElevation(7.dp),
    shape = RoundedCornerShape(16.dp)
  ) {
    Row(
      modifier = modifier
        .padding(12.dp)
        .fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = item.name, style = TextStyle(
          fontFamily = FontFamily.Monospace,
          fontSize = 20.sp
        )
      )
      Checkbox(checked = item.done, onCheckedChange = {updateItem()})
    }
  }
}


