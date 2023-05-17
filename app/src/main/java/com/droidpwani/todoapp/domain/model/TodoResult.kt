package com.droidpwani.todoapp.domain.model

sealed interface TodoResult {

  @JvmInline
  value class Empty(val message: String = "No Items Found") : TodoResult
  data class Content(val todoItems: List<TodoItem>) : TodoResult
  @JvmInline
  value class Error(val errorMsg: String) : TodoResult
}