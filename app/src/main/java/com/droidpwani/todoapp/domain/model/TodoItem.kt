package com.droidpwani.todoapp.domain.model

import com.droidpwani.todoapp.data.local.model.TodoEntity

data class TodoItem(
  val id: Int = 0,
  val task: String,
  val done: Boolean = false
)

fun TodoItem.toEntity() = TodoEntity(
  task = this.task
)


