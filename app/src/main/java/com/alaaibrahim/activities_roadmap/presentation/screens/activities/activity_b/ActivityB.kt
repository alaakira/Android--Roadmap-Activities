package com.alaaibrahim.activities_roadmap.presentation.screens.activities.activity_b

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.alaaibrahim.activities_roadmap.R
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.BaseActivity
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.activity_a.ActivityA
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.single_top.SingleTopActivity

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
        findViewById<Button>(R.id.activityB_sameActivity)
            .setOnClickListener {
                val bIntent = getIntent(this)
                startActivity(bIntent)

            }
        findViewById<Button>(R.id.activityB_aActivity)
            .setOnClickListener {
                val intent = ActivityA.getIntent(this)
                startActivity(intent)
            }
        findViewById<Button>(R.id.activityB_singleTop)
            .setOnClickListener {
                val intent = SingleTopActivity.getIntent(this)
                startActivity(intent)
            }
    }
}