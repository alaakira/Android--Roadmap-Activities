package com.alaaibrahim.activities_roadmap.presentation.screens.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alaaibrahim.activities_roadmap.presentation.ActivityState
import com.alaaibrahim.activities_roadmap.presentation.screens.loggers.TaskCounter
import com.alaaibrahim.activities_roadmap.utils.loggers.Loggers
import java.util.Date

abstract class BaseActivity : AppCompatActivity(){

    abstract val primaryTag: String

    private val creationDate = Date().time

    protected var activityState: ActivityState? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(MyLifecycleObserver())
        TaskCounter.addTaskConsumer(TaskCounter.TaskConsumer(taskId, primaryTag, creationDate))
        Loggers.logI(primaryTag, Loggers.ACTIVITY_TASK_ID_LOGGER_TAG, taskId.toString())
        Loggers.logI(primaryTag, Loggers.ACTIVITY_LIFECYCLE_LOGGER_TAG,
            ActivityState.CREATED.getProcessName())
        activityState = ActivityState.CREATED
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Loggers.logI(
            primaryTag, Loggers.ACTIVITY_LIFECYCLE_LOGGER_TAG,
            ActivityState.INTENT_RECEIVED.getProcessName()
        )
        activityState = ActivityState.INTENT_RECEIVED
    }

    override fun onStart() {
        super.onStart()
        TaskCounter.printCurrentTask(taskId)
        Loggers.logI(primaryTag, Loggers.ACTIVITY_LIFECYCLE_LOGGER_TAG,
            ActivityState.STARTED.getProcessName())
        activityState = ActivityState.STARTED
    }

    override fun onResume() {
        super.onResume()
        Loggers.logI(primaryTag, Loggers.ACTIVITY_LIFECYCLE_LOGGER_TAG,
            ActivityState.RESUMED.getProcessName())
        activityState = ActivityState.RESUMED
    }

    override fun onPause() {
        super.onPause()
        Loggers.logI(primaryTag, Loggers.ACTIVITY_LIFECYCLE_LOGGER_TAG,
            ActivityState.PAUSED.getProcessName())
        activityState = ActivityState.PAUSED
    }

    override fun onStop() {
        super.onStop()
        Loggers.logI(primaryTag, Loggers.ACTIVITY_LIFECYCLE_LOGGER_TAG,
            ActivityState.STOPPED.getProcessName())
        activityState = ActivityState.STOPPED
    }

    override fun onRestart() {
        super.onRestart()
        Loggers.logI(primaryTag, Loggers.ACTIVITY_LIFECYCLE_LOGGER_TAG,
            ActivityState.RESTARTED.getProcessName())
        activityState = ActivityState.RESTARTED
    }

    override fun onDestroy() {
        super.onDestroy()
        Loggers.logI(
            primaryTag,
            Loggers.ACTIVITY_TASK_ID_LOGGER_TAG + " - " + ActivityState.DESTROYED.getProcessName(),
            taskId.toString()
        )
        TaskCounter.removeTaskConsumer(TaskCounter.TaskConsumer(taskId, primaryTag, creationDate))
        TaskCounter.printCurrentTask(-1)
        Loggers.logI(primaryTag, Loggers.ACTIVITY_LIFECYCLE_LOGGER_TAG,
            ActivityState.DESTROYED.getProcessName())
        activityState = ActivityState.DESTROYED
    }

}