package ru.kirshov.todohomework.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo_table")
    fun allTodo():Flow<List<TodoRecord>>
    @Insert
    fun addTodo(todoRecord: TodoRecord)
    @Delete
    fun removeTodo(todoRecord: TodoRecord)
    @Update
    fun updateTodo(todoRecord: TodoRecord)
    @Query("SELECT * FROM todo_table WHERE id=:id")
    fun selectTodo(id:Int):TodoRecord?
}