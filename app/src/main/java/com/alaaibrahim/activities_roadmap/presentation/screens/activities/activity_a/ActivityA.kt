package com.alaaibrahim.activities_roadmap.presentation.screens.activities.activity_a

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.alaaibrahim.activities_roadmap.R
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.BaseActivity
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.activity_b.ActivityB

class ActivityA: BaseActivity() {

    companion object {
        fun getIntent(context: Context) = Intent(context, ActivityA::class.java)

    }

    override val primaryTag: String = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        setListeners()
    }

    private fun setListeners() {
        findViewById<Button>(R.id.activityA_nextBtn)
            .setOnClickListener {
                val intent = ActivityB.getIntent(this)
                startActivity(intent)
            }
    }
}