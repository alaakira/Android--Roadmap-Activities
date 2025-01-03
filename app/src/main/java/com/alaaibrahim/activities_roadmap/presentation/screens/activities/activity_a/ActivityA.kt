package com.alaaibrahim.activities_roadmap.presentation.screens.activities.activity_a

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.alaaibrahim.activities_roadmap.R
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.ACTIVITY_NAME_EXTRA
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.BaseActivity
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.activity_b.ActivityB
import com.alaaibrahim.activities_roadmap.utils.loggers.Loggers

class ActivityA: BaseActivity() {

    companion object {
        fun getIntent(context: Context) = Intent(context, ActivityA::class.java)

    }

    override val primaryTag: String = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        readActivityMessages()
        setListeners()
    }

    private fun setListeners() {
        findViewById<Button>(R.id.activityA_nextBtn)
            .setOnClickListener {
                val bIntent = ActivityB.getIntent(this)
                wrapActivityName(bIntent)
                startActivity(bIntent)
            }
    }

    private fun readActivityMessages() {
        intent?.apply {
            getStringExtra(ACTIVITY_NAME_EXTRA)?.let { message ->
                Loggers.logI(javaClass.simpleName, Loggers.ACTIVITY_MESSAGE_LOGGER_TAG, message)
            }
            removeExtra(ACTIVITY_NAME_EXTRA)
        }
    }

    private fun wrapActivityName(nextIntent: Intent) {
        nextIntent.apply {
            putExtra(ACTIVITY_NAME_EXTRA, this@ActivityA.javaClass.simpleName)
        }
    }
}