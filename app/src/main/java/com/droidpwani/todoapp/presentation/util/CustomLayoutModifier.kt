package com.droidpwani.todoapp.presentation.util

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

fun Modifier.takeHalfParentWidthCentered(): Modifier {
  return layout { measurable, constraints ->
    val maxAllowedWidth = constraints.maxWidth
    val placeable = measurable.measure(
      constraints = constraints.copy(minWidth = maxAllowedWidth / 2)
    )
    layout(placeable.width, placeable.height){
      placeable.placeRelative(
        maxAllowedWidth/2 - placeable.width/2, 0
      )
    }
  }
}