package com.droidpwani.todoapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidpwani.todoapp.TAG
import com.droidpwani.todoapp.domain.model.TodoItem
import com.droidpwani.todoapp.domain.model.TodoResult
import com.droidpwani.todoapp.domain.repository.TodoRepository
import com.droidpwani.todoapp.presentation.uiState.AddItemUiState
import com.droidpwani.todoapp.presentation.uiState.TodoUiState
import com.droidpwani.todoapp.presentation.uiState.TodoUiState.Empty
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import logcat.logcat

class TodoViewModel(
  private val todoRepository: TodoRepository
) : ViewModel() {

  private val _todoUiState: MutableStateFlow<TodoUiState> = MutableStateFlow(Empty())
  val todoUiState get() = _todoUiState.asStateFlow()

  private val _addItemUiState: MutableStateFlow<AddItemUiState> =
    MutableStateFlow(AddItemUiState.Idle)
  val addItemUiState get() = _addItemUiState.asStateFlow()


  fun getTodoItems() {
    viewModelScope.launch {
      logcat("TODOiTEMSScreen"){"vm getting started"}
      todoRepository.getTodoItems()
        .onStart {
          _todoUiState.value = TodoUiState.Loading
        }
        .catch { exception ->
          logcat("TodoViewModel") { "Exception => ${exception.message}" }
          _todoUiState.value =
            TodoUiState.Error(exception.message ?: "Whoops! Something went wrong")
        }
        .collectLatest { result ->
          when (result) {
            is TodoResult.Content -> {
              val items = result.todoItems.toImmutableList()
              if (items.isEmpty()){
                _todoUiState.value = Empty()
              }else{
                _todoUiState.value = TodoUiState.Content(todoItems = items)
              }
            }

            is TodoResult.Error -> {
              val error = result.errorMsg
              _todoUiState.value = TodoUiState.Error(errorMsg = error)
            }

            is TodoResult.Empty -> {
              _todoUiState.value = Empty()
            }
          }
        }
    }
  }

  fun saveTodoItem(item: String) {
    viewModelScope.launch {
      val todoItem = TodoItem(
        task = item
      )
      todoRepository.saveTodoItem(todoItem).onStart {
        _addItemUiState.value = AddItemUiState.Loading
      }.catch { exception ->
        logcat("TodoViewModel") { "Something known went wrong ${exception.message}" }
        _addItemUiState.value = AddItemUiState.Error("Something went Wrong")
      }.collectLatest { result ->
        if (result.isSuccess) {
          _addItemUiState.value = AddItemUiState.Success()
        } else {
          logcat("TodoViewModel") { "Something prolly unknown went wrong ${result.exceptionOrNull()?.message}" }
          _addItemUiState.value =
            AddItemUiState.Error(result.exceptionOrNull()?.message ?: "Something went wrong")
        }

      }
    }
  }

  override fun onCleared() {
    super.onCleared()
    logcat(TAG) { "VM cleared" }
  }
}