package com.alaaibrahim.activities_roadmap.presentation.screens.activities.activity_b

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.alaaibrahim.activities_roadmap.R
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.BaseActivity
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.activity_a.ActivityA

class ActivityB : BaseActivity() {

    companion object {
        fun getIntent(context: Context) = Intent(context, ActivityB::class.java)

    }

    override val primaryTag: String = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        setListeners()
    }

    private fun setListeners() {

        findViewById<Button>(R.id.activityB_backBtn).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        findViewById<Button>(R.id.activityB_nextBtn).setOnClickListener {
            val intent = ActivityA.getIntent(this)
            startActivity(intent)
        }
    }
}