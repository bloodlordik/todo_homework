package ru.kirshov.todohomework.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import ru.kirshov.todohomework.data.AppDispatchers
import ru.kirshov.todohomework.data.TodoDao


class ToDoRepository(
    private val localDataBase: TodoDao,
    private val dispatchers: AppDispatchers
) {
    val allTodos: Flow<List<TodoItemModel>> =
        localDataBase.allTodo().map { list -> list.map { TodoItemModel.fromEntity(it) } }
            .flowOn(dispatchers.io)
    suspend fun addTodo(todoItemModel: TodoItemModel) = withContext(dispatchers.io){
        localDataBase.addTodo(todoItemModel.toEntity())
    }
    suspend fun removeTodo(todoItemModel: TodoItemModel) = withContext(dispatchers.io){
        localDataBase.removeTodo(todoItemModel.toEntity())
    }
    suspend fun updateTodo(todoItemModel: TodoItemModel) = withContext(dispatchers.io){
        localDataBase.updateTodo(todoItemModel.toEntity())
    }
    fun selectTodo(id:Int) = flow<TodoItemModel?> {
        val todo = localDataBase.selectTodo(id)
        if (todo == null){
            emit(null)
        }else{
            emit(TodoItemModel.fromEntity(todo))
        }
    }.flowOn(dispatchers.io)
}
