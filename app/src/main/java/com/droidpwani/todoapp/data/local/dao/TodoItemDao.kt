package com.droidpwani.todoapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.droidpwani.todoapp.data.local.model.TodoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoItemDao {
  @Insert
  suspend fun saveToDoItem(item: TodoEntity): Long

  @Delete
  suspend fun removeTodoItem(item: TodoEntity): Int

  @Update
  suspend fun updateTodoItem(item: TodoEntity): Int


  @Query("SELECT * FROM todo_item")
  fun getAllTodoItems(): Flow<List<TodoEntity>>
}