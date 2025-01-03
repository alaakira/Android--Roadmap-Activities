package com.alaaibrahim.activities_roadmap.presentation.screens.activities.activity_a

import android.os.Bundle
import com.alaaibrahim.activities_roadmap.R
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.BaseActivity

class ActivityA: BaseActivity() {

    override val primaryTag: String = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
    }
}