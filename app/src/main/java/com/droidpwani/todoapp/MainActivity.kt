package com.droidpwani.todoapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.droidpwani.todoapp.ui.screens.TodoScreen
import com.droidpwani.todoapp.ui.theme.TodoAppTheme

const val TAG = "TODO_APP"
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      TodoAppTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          TodoScreen()
        }
      }
    }
  }
}


data class TodoItem(
  val itemId: Int = 0,
  val name: String = "Complete the slides" ,
  val done: Boolean = false
)

val todoItem = TodoItem(
  itemId = 1,
  name = "Complete Slides",
  done = false
)
val todoItem2 = TodoItem(
  itemId = 2,
  name = "Go for a walk",
  done = false
)
class Ref(var value: Int)


@Composable
inline fun LogCompositions(tag: String, msg: String) {
  val ref = remember { Ref(0) }
  SideEffect { ref.value++ }
  Log.d(tag, "Compositions: $msg ${ref.value}")
}






