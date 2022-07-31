package ru.kirshov.todohomework.di

import androidx.room.Room
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.kirshov.todohomework.data.TodoDatabase
import ru.kirshov.todohomework.domain.MainViewModel
import ru.kirshov.todohomework.domain.ToDoRepository

val appModule = module {
    single { Room.databaseBuilder(get(),TodoDatabase::class.java, "todo_data").build() }
    factory { ToDoRepository(get()) }
    viewModel { MainViewModel(get()) }

}