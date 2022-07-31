package ru.kirshov.todohomework.domain


import ru.kirshov.todohomework.data.AppDispatchers
import ru.kirshov.todohomework.data.TodoDatabase

class ToDoRepository(
    private val localDataBase: TodoDatabase,
    private val dispatchers: AppDispatchers
) {

}