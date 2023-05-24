package com.droidpwani.todoapp.presentation.actions

sealed interface TodoUiAction {
  object FetchTodoItems: TodoUiAction
  @JvmInline
  value class SaveItem(val item: String): TodoUiAction
}