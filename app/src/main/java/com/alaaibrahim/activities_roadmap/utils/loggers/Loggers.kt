package com.alaaibrahim.activities_roadmap.utils.loggers

import android.util.Log

object Loggers {

    const val ACTIVITY_LIFECYCLE_LOGGER_TAG = "ACTIVITY_LIFECYCLE_LOGGER"
    const val ACTIVITY_TASK_ID_LOGGER_TAG = "ACTIVITY_TASK_ID_LOGGER"
    const val ACTIVITY_TASK_COUNTER_LOGGER_TAG = "ACTIVITY_TASK_COUNTER_LOGGER"
    const val ACTIVITY_LIFECYCLE_OBSERVER_LOGGER_TAG = "ACTIVITY_LIFECYCLE_OBSERVER_LOGGER"
    const val ACTIVITY_SAVED_STATE_LOGGER_TAG = "ACTIVITY_SAVED_STATE_LOGGER_TAG"

    fun logI(primaryTag: String, tag: String, message: String) {
        Log.i("${primaryTag}__$tag", message)
    }

}