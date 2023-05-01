package com.droidpwani.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.droidpwani.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      TodoAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

        }
      }
    }
  }
}


/**
 * Task: Creating a business card
 * TODO 1: Create a BusinessCard Composable to show Your name
 */

/**
 * Task: Creating a business card
 * TODO 2: Add your email address to the BusinessCard composable
 *  The email address will be in a row. The row will have an icon. Use `ic_email` drawable and
 *  text showing your email address
 */

/**
 * Task: Creating a business card
 * TODO 3: Add an user image at the top of the BusinessCard Composable
 *   The Image should be centered in the UI,
 *   The image has a height of 200.dp
 *   The image is of a circle shape
 *
 */



