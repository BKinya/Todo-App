package com.droidpwani.todoapp.domain.repository

import com.droidpwani.todoapp.domain.model.TodoItem
import com.droidpwani.todoapp.domain.model.TodoResult
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
  fun getTodoItems(): Flow<TodoResult>

  suspend fun saveTodoItem(item: TodoItem): Result<String>

  suspend fun deleteTodoItem(item: TodoItem)

  suspend fun updateTodoItem(item: TodoItem)
}