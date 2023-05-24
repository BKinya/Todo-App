package com.droidpwani.todoapp.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidpwani.todoapp.R
import com.droidpwani.todoapp.domain.model.TodoItem
import logcat.logcat
import kotlin.math.log

@Preview
@Composable
fun TodoItemComponent(
  modifier: Modifier = Modifier,
  todoItem: TodoItem = TodoItem(id = 0, task = "Complete sample project", done = false),
  markItemAsDone: (TodoItem) -> Unit = {},
  removeAnItem: (TodoItem) -> Unit = {}

) {
  Card(
    modifier = modifier.padding(16.dp),
    elevation = CardDefaults.cardElevation(4.dp),
    shape = RoundedCornerShape(12.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White)
  ) {
    Row(
      modifier = modifier
        .fillMaxWidth()
        .padding(16.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Checkbox(
        checked = todoItem.done,
        onCheckedChange = {
          markItemAsDone(todoItem)
        },
      )

      Text(
        text = todoItem.task, style = TextStyle(
          fontWeight = FontWeight.Normal,
          fontSize = 17.sp,
          fontFamily = FontFamily.Monospace,
          color = Color.DarkGray
        )
      )

      Box(
        modifier = modifier.fillMaxWidth()
      ) {
        Icon(
          modifier = modifier.align(Alignment.CenterEnd).clickable{
            removeAnItem(todoItem)
          }
          ,
          painter = painterResource(id = R.drawable.ic_clear), contentDescription = "Clear Icon",
          tint = Color.Gray
        )
      }

    }
  }
}