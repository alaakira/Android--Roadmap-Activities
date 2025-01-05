package com.alaaibrahim.activities_roadmap.presentation.screens.loggers

import com.alaaibrahim.activities_roadmap.utils.loggers.Loggers
import com.alaaibrahim.activities_roadmap.utils.loggers.Loggers.ACTIVITY_TASK_COUNTER_LOGGER_TAG
import java.util.Date

object TaskCounter {

    private val map = HashMap<Int, MutableList<TaskConsumer>>()

    fun addTaskConsumer(taskConsumer: TaskConsumer) {
        with(taskConsumer) {
            val oldList = map[taskId] ?: mutableListOf()
            map[taskId] = oldList.apply {
                add(taskConsumer)
            }
        }
    }

    fun removeTaskConsumer(taskConsumer: TaskConsumer) {
        with(taskConsumer) {
            map[taskId]?.let { safeTaskConsumersList ->
                safeTaskConsumersList.findLast { currentTaskConsumer ->
                    currentTaskConsumer.consumerName == taskConsumer.consumerName
                }?.let {
                    safeTaskConsumersList.remove(it)
                }
            }
            if (map[taskId].isNullOrEmpty())
                map.remove(taskId)
        }
    }

    fun printCurrentTask(currentTaskId: Int) {
        Loggers.logI(
            javaClass.simpleName,
            ACTIVITY_TASK_COUNTER_LOGGER_TAG,
            currentTaskId.toString()
        )
        Loggers.logI(javaClass.simpleName, ACTIVITY_TASK_COUNTER_LOGGER_TAG, map.toString())
    }

    data class TaskConsumer(val taskId: Int, val consumerName: String) {

        val creationDate = Date().time

        override fun toString(): String {
            return consumerName
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TaskConsumer

            if (taskId != other.taskId) return false
            if (consumerName != other.consumerName) return false
            if (creationDate != other.creationDate) return false

            return true
        }

        override fun hashCode(): Int {
            var result = taskId
            result = 31 * result + consumerName.hashCode()
            result = 31 * result + creationDate.hashCode()
            return result
        }


    }

}