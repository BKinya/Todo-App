package com.droidpwani.todoapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.droidpwani.todoapp.presentation.screen.AddItemScreen
import com.droidpwani.todoapp.presentation.screen.TodoItemsScreen
import com.droidpwani.todoapp.presentation.viewmodel.TodoViewModel

@Composable
fun TodoNavHost(
    navController: NavHostController,
    todoViewModel: TodoViewModel,
    modifier: Modifier = Modifier

) {
    NavHost(navController = navController, startDestination = TodoAppScreens.TodoList.route) {
        composable(TodoAppScreens.TodoList.route) {
            TodoItemsScreen(
                modifier = modifier,
                todoViewModel = todoViewModel,
                navigateToAddItemScreen = { navController.navigate(TodoAppScreens.AddItem.route) }
            )
        }

        composable(TodoAppScreens.AddItem.route) {
            AddItemScreen(
                modifier = modifier,
                navigateToTodoListScreen = { navController.navigate(TodoAppScreens.TodoList.route) }
            )
        }
    }
}
