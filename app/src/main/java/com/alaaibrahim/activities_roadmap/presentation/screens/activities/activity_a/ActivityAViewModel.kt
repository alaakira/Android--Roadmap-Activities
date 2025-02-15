package com.alaaibrahim.activities_roadmap.presentation.screens.activities.activity_a

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.alaaibrahim.activities_roadmap.utils.loggers.Loggers
import kotlin.random.Random

class ActivityAViewModel(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    var lastInsertedValue: String? = null

    init {
        savedStateHandle["TESTING_VALUE"] = Random.nextInt()
        Loggers.logI(
            javaClass.simpleName,
            Loggers.ACTIVITY_SAVED_STATE_LOGGER_TAG,
            "Init View Model with value: $lastInsertedValue"
        )
    }

    fun getTestingValue(): Int? = savedStateHandle["TESTING_VALUE"]

}