package com.droidpwani.todoapp

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.droidpwani.todoapp.presentation.navigation.TodoNavHost
import com.droidpwani.todoapp.presentation.screen.TodoItemsScreen
import com.droidpwani.todoapp.presentation.theme.TodoAppTheme
import com.droidpwani.todoapp.presentation.viewmodel.TodoViewModel
import logcat.logcat
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * TODO App
 * Good to have ... A progress bar
 * Good to have ... Unit tests and others
 */
const val TAG = "TODO_APP"
class MainActivity : ComponentActivity() {
  val todoViewModel: TodoViewModel by viewModel()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val navController = rememberNavController()
      TodoAppTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
         TodoNavHost(navController = navController, todoViewModel = todoViewModel)
        }
      }
    }
  }
}




