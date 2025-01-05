package com.alaaibrahim.activities_roadmap.presentation.screens.activities.launch_mode

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.alaaibrahim.activities_roadmap.R
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.BaseActivity
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.activity_a.ActivityA
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.activity_b.ActivityB

class SingleInstanceActivity : BaseActivity() {

    override val primaryTag: String = javaClass.simpleName

    companion object {
        fun getIntent(context: Context) = Intent(context, SingleInstanceActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)
        setListeners()
    }

    private fun setListeners() {
        findViewById<Button>(R.id.aActivityBtn)
            .setOnClickListener {
                val bIntent = ActivityA.getIntent(this)
                startActivity(bIntent)
            }

        findViewById<Button>(R.id.bActivityBtn)
            .setOnClickListener {
                val intent = ActivityB.getIntent(this)
                startActivity(intent)
            }

        findViewById<Button>(R.id.singleTopBtn)
            .setOnClickListener {
                val intent = SingleTopActivity.getIntent(this)
                startActivity(intent)
            }

        findViewById<Button>(R.id.singleTaskBtn)
            .setOnClickListener {
                val intent = SingleTaskActivity.getIntent(this)
                startActivity(intent)
            }

        findViewById<Button>(R.id.singleInstanceBtn)
            .setOnClickListener {
                val intent = getIntent(this)
                startActivity(intent)
            }

        findViewById<Button>(R.id.singleInstancePerTaskBtn)
            .setOnClickListener {
                val intent = SingleInstancePerTaskActivity.getIntent(this)
                startActivity(intent)
            }
    }

}