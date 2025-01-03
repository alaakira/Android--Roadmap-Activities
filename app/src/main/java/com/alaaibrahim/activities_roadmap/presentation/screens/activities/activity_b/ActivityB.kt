package com.alaaibrahim.activities_roadmap.presentation.screens.activities.activity_b

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.alaaibrahim.activities_roadmap.R
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.ACTIVITY_NAME_EXTRA
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.BaseActivity
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.activity_a.ActivityA
import com.alaaibrahim.activities_roadmap.utils.loggers.Loggers
import com.alaaibrahim.activities_roadmap.utils.loggers.Loggers.ACTIVITY_MESSAGE_LOGGER_TAG

class ActivityB : BaseActivity() {

    companion object {
        fun getIntent(context: Context) = Intent(context, ActivityB::class.java)

    }

    override val primaryTag: String = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        readActivityMessages()
        setListeners()
    }

    private fun readActivityMessages() {
        intent?.apply {
            getStringExtra(ACTIVITY_NAME_EXTRA)?.let { message ->
                Loggers.logI(javaClass.simpleName, ACTIVITY_MESSAGE_LOGGER_TAG, message)
            }
        }
    }

    private fun setListeners() {

        findViewById<Button>(R.id.activityB_backBtn).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        findViewById<Button>(R.id.activityB_nextBtn).setOnClickListener {
            val aIntent = ActivityA.getIntent(this)
            wrapActivityName(aIntent)
            startActivity(aIntent)
        }
    }

    private fun wrapActivityName(nextIntent: Intent) {
        nextIntent.apply {
            putExtra(ACTIVITY_NAME_EXTRA, this@ActivityB.javaClass.simpleName)
        }
    }
}