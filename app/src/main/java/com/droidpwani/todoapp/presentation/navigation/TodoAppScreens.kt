package com.droidpwani.todoapp.presentation.navigation

sealed class TodoAppScreens(val route: String){
  object TodoList:TodoAppScreens(route = "todoList")
  object AddItem: TodoAppScreens(route = "addItem")
}