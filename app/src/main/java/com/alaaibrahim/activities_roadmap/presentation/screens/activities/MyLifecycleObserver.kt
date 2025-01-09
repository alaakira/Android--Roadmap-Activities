package com.alaaibrahim.activities_roadmap.presentation.screens.activities

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.alaaibrahim.activities_roadmap.utils.loggers.Loggers

class MyLifecycleObserver : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Loggers.logI(
            javaClass.simpleName,
            Loggers.ACTIVITY_LIFECYCLE_OBSERVER_LOGGER_TAG,
            "onCreate from observer"
        )
    }
}