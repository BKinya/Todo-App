package com.droidpwani.todoapp.presentation.screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.droidpwani.todoapp.presentation.actions.TodoUiAction
import com.droidpwani.todoapp.presentation.component.EmptyComponent
import com.droidpwani.todoapp.presentation.component.ErrorComponent
import com.droidpwani.todoapp.presentation.component.TodoListComponent
import com.droidpwani.todoapp.presentation.uiState.TodoUiState
import com.droidpwani.todoapp.presentation.viewmodel.TodoViewModel

@Composable
fun TodoItemsScreen(
  modifier: Modifier = Modifier,
  todoViewModel: TodoViewModel,
  navigateToAddItemScreen: () -> Unit
) {
  Scaffold { contentPadding ->
    LaunchedEffect(Unit ){
      todoViewModel.uiActions.tryEmit(TodoUiAction.FetchTodoItems)
    }
    val todoUiState by todoViewModel.todoUiState.collectAsStateWithLifecycle()
    when (todoUiState) {
      is TodoUiState.Empty -> {
        EmptyComponent(
          modifier = modifier,
          navigateToAddItemScreen = navigateToAddItemScreen
        )
      }

      is TodoUiState.Error -> {
        ErrorComponent(
          modifier = modifier
        )
      }

      is TodoUiState.Loading -> {

      }

      is TodoUiState.Content -> {
        val state = todoUiState as TodoUiState.Content
        TodoListComponent(
          modifier = modifier,
          todoItems = state.todoItems,
          markItemAsDone = {todoItem ->
            val updatedItem = todoItem.copy(done = !todoItem.done)
            todoViewModel.sendAction(TodoUiAction.UpdateItem(updatedItem))
          },
          navigateToAddItemScreen = navigateToAddItemScreen,
          removeItem = { itemToDelete ->
            todoViewModel.sendAction(TodoUiAction.DeleteItem(itemToDelete))
          }
        )
      }
    }
  }
}