package com.droidpwani.todoapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidpwani.todoapp.R


@Preview
@Composable
fun EmptyComponent(
  modifier: Modifier = Modifier,
  message: String = "Whoops! No Items found",
  navigateToAddItemScreen: () -> Unit = {},
) {
  Column(
    modifier = modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      text = message,
      style = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontSize = 18.sp,
        color = Color.DarkGray
      )
    )
    Spacer(modifier = modifier.height(4.dp))
    Icon(
      modifier = modifier
        .padding(16.dp)
        .size(57.dp)
        .shadow(elevation = 4.dp, clip = true, shape = CircleShape)
        .background(color = Color.LightGray)
        .clickable(onClick = navigateToAddItemScreen),
      painter = painterResource(id = R.drawable.ic_add),
      contentDescription = null,
      tint = Color.Gray
    )
  }
}

