package ru.kirshov.todohomework.domain

import androidx.room.Entity
import org.junit.Assert.*
import org.junit.Test
import ru.kirshov.todohomework.data.TodoRecord
import java.time.LocalDateTime
import kotlin.random.Random

class TodoItemModelTest{
    @Test
    fun modelToEntity(){
        val sampleData:List<TodoItemModel> = buildList {
            for (i in 0.. 100){
                add(
                    TodoItemModel(
                        content = "test",
                        id = Random.nextInt(),
                        isDone = Random.nextBoolean(),
                        createdDateTime = randomDate(),
                        changedDateTime = if (Random.nextBoolean()) null else randomDate(),
                        deadLine = if (Random.nextBoolean()) null else randomDate(),
                        priority = when(Random.nextInt(3)){
                            0 -> ToDoPriority.LOW
                            1 ->ToDoPriority.NORMAL
                            2->ToDoPriority.HIGH
                            else -> ToDoPriority.LOW
                        }
                    )
                )
            }
        }
        sampleData.forEach{model->
            val value = model.toEntity()
            val test = TodoItemModel.fromEntity(value)
            assert(model == test)
        }
    }
}

fun randomDate():LocalDateTime{
    return LocalDateTime.of(
        Random.nextInt(1987, 2034),
        Random.nextInt(1,11),
        Random.nextInt(1,27),
        Random.nextInt(1,22),
        Random.nextInt(1,59)
    )
}