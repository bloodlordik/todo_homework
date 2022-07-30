package ru.kirshov.todohomework.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo_table")
    fun allTodo():Flow<List<TodoRecord>>
}