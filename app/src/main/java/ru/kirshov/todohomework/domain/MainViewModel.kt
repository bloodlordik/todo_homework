package ru.kirshov.todohomework.domain

import androidx.lifecycle.ViewModel
import ru.kirshov.todohomework.data.AppDispatchers

class MainViewModel(
    private val toDoRepository: ToDoRepository,
    private val dispatchers: AppDispatchers
):ViewModel() {

}