package ru.kirshov.todohomework.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class TodoRecord(
    val content:String,
    @PrimaryKey(autoGenerate = true) val id:Int
)