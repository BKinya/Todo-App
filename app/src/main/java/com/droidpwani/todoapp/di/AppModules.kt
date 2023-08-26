package com.droidpwani.todoapp.di

import androidx.room.Room
import com.droidpwani.todoapp.data.local.TodoDatabase
import com.droidpwani.todoapp.data.local.repository.TodoRepositoryImpl
import com.droidpwani.todoapp.domain.repository.TodoRepository
import com.droidpwani.todoapp.presentation.viewmodel.TodoViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            TodoDatabase::class.java,
            "todo-database"
        ).build()
    }
    single { get<TodoDatabase>().todoItemDao() }
    single<TodoRepository> { TodoRepositoryImpl(get()) }
    viewModel { TodoViewModel(get()) }
}
