package com.droidpwani.todoapp

import android.os.Bundle
import android.widget.ImageView.ScaleType
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.droidpwani.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      TodoAppTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        }
      }
    }
  }
}



/**
 * Task: Creating a business card
 * TODO 1: Create a BusinessCard Composable to show Your name
 *
 *
 * TODO 2: Add your email address to the BusinessCard composable
 *  The email address will be in a row. The row will have an icon. Use `ic_email` drawable and
 *  text showing your email address
 *
 *
 * TODO 3: Add an user image at the top of the BusinessCard Composable
 *   The Image should be centered in the UI,
 *   The image has a height of 200.dp
 *   The image is of a circle shape
 *
 *  TODO 4: Make the user image the background
 *    Write user details on top of the image: Name and email
 *    Both name and email will be centered horizontally and vertically
 *
 *  \
 *
 */



