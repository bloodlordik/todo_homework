package ru.kirshov.todohomework.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TodoRecord::class], version = 1, exportSchema = false)
abstract class TodoDatabase:RoomDatabase() {
    abstract fun todoDao():TodoDao
}