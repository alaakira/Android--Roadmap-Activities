package com.alaaibrahim.activities_roadmap.utils.loggers

import android.util.Log

object Loggers {

    const val ACTIVITY_LIFECYCLE_LOGGER_TAG = "ACTIVITY_LIFECYCLE_LOGGER"
    const val ACTIVITY_MESSAGE_LOGGER_TAG = "ACTIVITY_MESSAGE_LOGGER"
    const val ACTIVITY_RESULT_LOGGER_TAG = "ACTIVITY_RESULT_LOGGER"

    fun logI(primaryTag: String, tag: String, message: String) {
        Log.i("${primaryTag}__$tag", message)
    }

}