package com.droidpwani.todoapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.droidpwani.todoapp.presentation.component.ErrorComponent
import com.droidpwani.todoapp.presentation.component.ProgressIndicator
import com.droidpwani.todoapp.presentation.uiState.AddItemUiState
import com.droidpwani.todoapp.presentation.util.takeHalfParentWidthCentered
import com.droidpwani.todoapp.presentation.viewmodel.TodoViewModel
import logcat.logcat
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AddItemScreen(
  modifier: Modifier = Modifier,
  todoViewModel: TodoViewModel = koinViewModel(),
  onSubmitClicked: (item: String) -> Unit = {},
  navigateToTodoListScreen: () -> Unit = {}
) {
  var item by rememberSaveable { mutableStateOf("") }
  val uiState = todoViewModel.addItemUiState.collectAsStateWithLifecycle().value

  Scaffold(
    topBar = {
      TopAppBar(title = {
        Text(
          text = "Add an Item", style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.DarkGray
          )
        )
      })
    }
  ) { contentPadding ->

//    when(uiState){// fiXME: mighty remove
//      is AddItemUiState.Success -> navigateToTodoListScreen()
//      is AddItemUiState.Loading -> {}
//      is AddItemUiState.Error -> {}
//      else -> {}
//    }

    Surface(modifier = modifier.padding(contentPadding)) {
      Column(
        modifier = modifier
          .fillMaxWidth()
          .fillMaxHeight()
          .padding(24.dp),
      ) {
        Text(

          text = "Todo Item",
          style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 17.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.DarkGray
          )
        )
        Spacer(modifier = modifier.height(12.dp))
        OutlinedTextField(
          modifier = modifier.fillMaxWidth(),
          value = item,
          onValueChange = { newValue ->
            item = newValue
          },
          textStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 17.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.DarkGray
          )
        )
        Spacer(modifier = modifier.height(27.dp))
        Button(modifier = modifier.takeHalfParentWidthCentered(),
          onClick = {
            if (item.isNotEmpty()) {
              todoViewModel.saveTodoItem(item)
              navigateToTodoListScreen()// TODO: lOOK AT LATER
            }
          }) {
          Text(
            text = "Save Item",
            style = TextStyle(
              fontFamily = FontFamily.Monospace,
              fontSize = 16.sp,
              color = Color.White
            )
          )

        }
      }
    }
  }
}