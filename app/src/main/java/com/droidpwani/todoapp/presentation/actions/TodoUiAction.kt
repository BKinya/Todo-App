package com.droidpwani.todoapp.presentation.actions

import com.droidpwani.todoapp.domain.model.TodoItem

sealed interface TodoUiAction {
  object FetchTodoItems: TodoUiAction
  @JvmInline
  value class SaveItem(val item: String): TodoUiAction

  @JvmInline
  value class UpdateItem(val updatedItem: TodoItem): TodoUiAction
}