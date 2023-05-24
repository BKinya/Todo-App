package com.droidpwani.todoapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidpwani.todoapp.domain.model.TodoItem
import com.droidpwani.todoapp.domain.model.TodoResult
import com.droidpwani.todoapp.domain.repository.TodoRepository
import com.droidpwani.todoapp.presentation.actions.TodoUiAction
import com.droidpwani.todoapp.presentation.uiState.AddUpdateItemUiState
import com.droidpwani.todoapp.presentation.uiState.TodoUiState
import com.droidpwani.todoapp.presentation.uiState.TodoUiState.Empty
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
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

  val addUpdateItemUiState = Channel<AddUpdateItemUiState>(Channel.BUFFERED)

  val uiActions = MutableSharedFlow<TodoUiAction>(extraBufferCapacity = 10)

  init {
    handleActions()
  }

  fun handleActions() {
    viewModelScope.launch {
      uiActions.collect { action ->
        when (action) {
          is TodoUiAction.FetchTodoItems -> getTodoItems()
          is TodoUiAction.SaveItem -> saveTodoItem(action.item)
          is TodoUiAction.UpdateItem -> updateAnItem(action.updatedItem)
          is TodoUiAction.DeleteItem -> deleteAnItem(action.itemToDelete)
        }
      }
    }
  }

  fun getTodoItems() {
    viewModelScope.launch {
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
              if (items.isEmpty()) {
                _todoUiState.value = Empty()
              } else {
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
      val result = todoRepository.saveTodoItem(todoItem)
      if (result.isSuccess) {
        addUpdateItemUiState.send(AddUpdateItemUiState.Success())
      } else {
        logcat("TodoViewModel") { "Something probably unknown went wrong ${result.exceptionOrNull()?.message}" }
        val message = result.exceptionOrNull()?.message ?: "Something went wrong"
        addUpdateItemUiState.send(AddUpdateItemUiState.Error(message))
      }
    }
  }


  fun sendAction(action: TodoUiAction) {
    uiActions.tryEmit(action)
  }

  fun updateAnItem(updatedItem: TodoItem) {
    viewModelScope.launch {
      todoRepository.updateTodoItem(updatedItem)
    }
  }

  fun deleteAnItem(itemToDelete: TodoItem){
    viewModelScope.launch {
      todoRepository.deleteTodoItem(itemToDelete)
    }
  }
}
