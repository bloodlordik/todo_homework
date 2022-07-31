package ru.kirshov.todohomework.data

import kotlinx.coroutines.CoroutineDispatcher

interface AppDispatchers {
    val io:CoroutineDispatcher
    val main:CoroutineDispatcher
}