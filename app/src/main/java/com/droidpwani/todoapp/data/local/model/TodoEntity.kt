package com.droidpwani.todoapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.droidpwani.todoapp.domain.model.TodoItem

@Entity(tableName = "todo_item")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val task: String,
    val done: Boolean = false
)

fun TodoEntity.toDomain(): TodoItem = TodoItem(
    id = this.id,
    task = this.task,
    done = this.done
)
