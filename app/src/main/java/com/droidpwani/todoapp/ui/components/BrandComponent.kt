package com.droidpwani.todoapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidpwani.todoapp.R

@Preview
@Composable
fun BrandComponent(modifier: Modifier = Modifier) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(12.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {


    Column(
      verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Droid",
        style = TextStyle(
          fontFamily = FontFamily.Monospace,
          fontSize = 24.sp,
          fontWeight = FontWeight.ExtraBold
        )
        )
      Spacer(modifier = modifier.height(12.dp) )
      Text(text = "Pwani",
        style = TextStyle(
          fontFamily = FontFamily.Monospace,
          fontSize = 18.sp,
          fontWeight = FontWeight.SemiBold
        )
      )
    }
  }
}