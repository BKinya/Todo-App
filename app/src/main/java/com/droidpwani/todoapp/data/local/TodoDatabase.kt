package com.droidpwani.todoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.droidpwani.todoapp.data.local.dao.TodoItemDao
import com.droidpwani.todoapp.data.local.model.TodoEntity

@Database(
    entities = [
        TodoEntity::class
    ],
    version = 1
)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoItemDao(): TodoItemDao
}
