package com.droidpwani.todoapp.data.local.repository

import com.droidpwani.todoapp.data.local.dao.TodoItemDao
import com.droidpwani.todoapp.data.local.model.toDomain
import com.droidpwani.todoapp.domain.model.TodoItem
import com.droidpwani.todoapp.domain.model.TodoResult
import com.droidpwani.todoapp.domain.model.toEntity
import com.droidpwani.todoapp.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import logcat.logcat

class TodoRepositoryImpl(
  private val todoItemDao: TodoItemDao
) : TodoRepository {
  override fun getTodoItems(): Flow<TodoResult> = flow {
    todoItemDao.getAllTodoItems()
      .catch { exception ->
        logcat("TodoRepository") { "An exception occurred ${exception.message}" }
        val error = TodoResult.Error(errorMsg = exception.message ?: "Something went wrong")
        emit(error)
      }
      .collect { entities ->
        val items = entities.map { it.toDomain() }
        logcat("TodoRepository") { "Count => ${items.size}" }
        val content = TodoResult.Content(todoItems = items)
        emit(content)
      }
  }

  override suspend fun saveTodoItem(item: TodoItem): Result<String> {
    val result = try {
      val result = todoItemDao.saveToDoItem(item.toEntity())
      if (result > 0) {
        Result.success("Item successfully saved")
      } else {
        logcat("TodoRepository") { "Something unknown went wrong" }
        Result.failure(exception = Exception("Something went wrong"))
      }
    } catch (e: Exception) {
      logcat("TodoRepository") { "Something known went wrong ${e.message}" }
      Result.failure(exception = e)
    }
    return result
  }


  override suspend fun deleteTodoItem(item: TodoItem) {
    try {
      val result = todoItemDao.removeTodoItem(item = item.toEntity())
      if (result > 0) {
        logcat("TodoRepository") { "Delete Successful" }
      } else {
        logcat("TodoRepository") { "[Delete]Something unknown went wrong" }
      }
    } catch (e: Exception) {
      logcat("TodoRepository") { "[Delete]Something known went wrong ${e.message}" }
    }
  }

  override suspend fun updateTodoItem(item: TodoItem) {
    try {
      val result = todoItemDao.updateTodoItem(item.toEntity())
      if (result > 0) {
        logcat("TodoRepository") { "Update Successful" }
      } else {
        logcat("TodoRepository") { "[Update]Something unknown went wrong" }
      }
    } catch (exception: Exception) {
      logcat("TodoRepository") { "[Update]Something known went wrong ${exception.message}" }
    }
  }
}