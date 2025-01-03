package com.alaaibrahim.activities_roadmap.presentation

enum class ActivityState {
    CREATED, STARTED, RESUMED, PAUSED, STOPPED, RESTARTED, DESTROYED;

    fun getProcessName() = when(this){
        CREATED -> "On Create"
        STARTED -> "On Start"
        RESUMED -> "On Resume"
        PAUSED -> "On Pause"
        STOPPED -> "On Stop"
        RESTARTED -> "On Restart"
        DESTROYED -> "On Destroy"
    }
}