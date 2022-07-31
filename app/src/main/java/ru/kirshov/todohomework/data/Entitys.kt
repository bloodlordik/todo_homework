package ru.kirshov.todohomework.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class TodoRecord(
    val content:String,
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    val priority:Int,
    val isDone:Boolean,
    val createdDateTime: String,
    val changedDateTime:String? = null,
    val deadLine: String? = null
)