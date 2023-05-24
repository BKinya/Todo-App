package com.droidpwani.todoapp.presentation.uiState

import com.droidpwani.todoapp.domain.model.TodoItem
import kotlinx.collections.immutable.ImmutableList

sealed interface TodoUiState {
  object Loading : TodoUiState

  @JvmInline
  value class Empty(val message: String = "Whoops! No items found.") : TodoUiState
  data class Content(val todoItems: ImmutableList<TodoItem>) : TodoUiState

  @JvmInline
  value class Error(val errorMsg: String) : TodoUiState
}


sealed interface AddUpdateItemUiState {

  @JvmInline
  value class Success(val message: String = "Successfully Added an item") : AddUpdateItemUiState

  @JvmInline
  value class Error(val errorMsg: String) :AddUpdateItemUiState
}