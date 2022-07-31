package ru.kirshov.todohomework.domain

import ru.kirshov.todohomework.data.TodoRecord
import java.time.LocalDateTime


data class TodoItemModel(
    val content: String,
    val id: Int = 0,
    val priority: ToDoPriority,
    val isDone: Boolean,
    val createdDateTime: LocalDateTime,
    val changedDateTime: LocalDateTime? = null,
    val deadLine: LocalDateTime? = null
){
    fun toEntity():TodoRecord{
        return TodoRecord(
            content = this.content,
            priority = when(this.priority){
                ToDoPriority.LOW -> 0
                ToDoPriority.NORMAL -> 1
                ToDoPriority.HIGH -> 2
            },
            isDone = this.isDone,
            createdDateTime = this.createdDateTime.toString(),
            changedDateTime = if (this.changedDateTime == null) null else this.changedDateTime.toString(),
            deadLine = if (this.deadLine == null) null else this.deadLine.toString()

        )
    }
    companion object{
        fun fromEntity(entity:TodoRecord):TodoItemModel{
            return TodoItemModel(
                content = entity.content,
                isDone = entity.isDone,
                createdDateTime = LocalDateTime.parse(entity.createdDateTime),
                changedDateTime = if (entity.changedDateTime==null) null else LocalDateTime.parse(entity.changedDateTime),
                deadLine = if (entity.deadLine == null) null else LocalDateTime.parse(entity.deadLine),
                priority = when(entity.priority){
                    0 -> ToDoPriority.LOW
                    1->ToDoPriority.NORMAL
                    2->ToDoPriority.HIGH
                    else -> ToDoPriority.LOW
                }
            )
        }
    }
}
enum class ToDoPriority{
    LOW, NORMAL, HIGH
}
