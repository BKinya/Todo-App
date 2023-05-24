package com.droidpwani.todoapp.presentation.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidpwani.todoapp.R
import com.droidpwani.todoapp.domain.model.TodoItem
import kotlinx.collections.immutable.ImmutableList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListComponent(
  modifier: Modifier = Modifier,
  todoItems: ImmutableList<TodoItem>,
  updateItem: (TodoItem) -> Unit,
  navigateToAddItemScreen: ()-> Unit
) {
  Scaffold(
    topBar = {
      TopAppBar(title = {
        Text(
          text = "My Todo List", style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.DarkGray
          )
        )
      })
    },
    floatingActionButton = {
      FloatingActionButton(
        modifier = modifier
            .shadow(elevation = 4.dp, clip = true, shape = CircleShape),
        onClick = navigateToAddItemScreen) {
        Icon(
          painter = painterResource(id = R.drawable.ic_add),
          contentDescription = null,
          tint = Color.Gray
        )
      }
    }
  ) { contentPadding ->
    LazyColumn(
      contentPadding = contentPadding
    ) {
      items(todoItems, key = { todoItem -> todoItem.id }) { item ->
        TodoItemComponent(
          modifier = modifier,
          todoItem = item,
          updateItem = updateItem
        )
      }
    }
  }

}