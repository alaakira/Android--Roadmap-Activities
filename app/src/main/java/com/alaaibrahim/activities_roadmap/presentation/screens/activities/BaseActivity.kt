package com.alaaibrahim.activities_roadmap.presentation.screens.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alaaibrahim.activities_roadmap.presentation.ActivityState
import com.alaaibrahim.activities_roadmap.utils.loggers.Loggers

abstract class BaseActivity : AppCompatActivity(){

    abstract val primaryTag: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Loggers.logI(primaryTag, Loggers.ACTIVITY_LIFECYCLE_LOGGER_TAG,
            ActivityState.CREATED.getProcessName())
    }

    override fun onStart() {
        super.onStart()
        Loggers.logI(primaryTag, Loggers.ACTIVITY_LIFECYCLE_LOGGER_TAG,
            ActivityState.STARTED.getProcessName())
    }

    override fun onResume() {
        super.onResume()
        Loggers.logI(primaryTag, Loggers.ACTIVITY_LIFECYCLE_LOGGER_TAG,
            ActivityState.RESUMED.getProcessName())
    }

    override fun onPause() {
        super.onPause()
        Loggers.logI(primaryTag, Loggers.ACTIVITY_LIFECYCLE_LOGGER_TAG,
            ActivityState.PAUSED.getProcessName())
    }

    override fun onStop() {
        super.onStop()
        Loggers.logI(primaryTag, Loggers.ACTIVITY_LIFECYCLE_LOGGER_TAG,
            ActivityState.STOPPED.getProcessName())
    }

    override fun onRestart() {
        super.onRestart()
        Loggers.logI(primaryTag, Loggers.ACTIVITY_LIFECYCLE_LOGGER_TAG,
            ActivityState.RESTARTED.getProcessName())
    }

    override fun onDestroy() {
        super.onDestroy()
        Loggers.logI(primaryTag, Loggers.ACTIVITY_LIFECYCLE_LOGGER_TAG,
            ActivityState.DESTROYED.getProcessName())
    }

}