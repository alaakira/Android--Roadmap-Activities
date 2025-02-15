package com.alaaibrahim.activities_roadmap.presentation.screens.activities.activity_a

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.core.widget.doOnTextChanged
import com.alaaibrahim.activities_roadmap.R
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.BaseActivity
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.activity_b.ActivityB
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.launch_mode.SingleInstanceActivity
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.launch_mode.SingleInstancePerTaskActivity
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.launch_mode.SingleTaskActivity
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.launch_mode.SingleTopActivity
import com.alaaibrahim.activities_roadmap.utils.loggers.Loggers

class ActivityA: BaseActivity() {

    companion object {
        fun getIntent(context: Context) = Intent(context, ActivityA::class.java)

    }

    override val primaryTag: String = javaClass.simpleName

    init {
        Loggers.logI(primaryTag, Loggers.ACTIVITY_SAVED_STATE_LOGGER_TAG, "init block")
    }


    private val viewModel: ActivityAViewModel by viewModels<ActivityAViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)
        Loggers.logI(
            primaryTag,
            Loggers.ACTIVITY_SAVED_STATE_LOGGER_TAG,
            "after creating: ${viewModel.lastInsertedValue}"
        )
        Loggers.logI(
            primaryTag,
            Loggers.ACTIVITY_SAVED_STATE_LOGGER_TAG,
            "testing value: ${viewModel.getTestingValue()}"
        )
        setListeners()
    }

    private fun setListeners() {
        findViewById<EditText>(R.id.inputField)
            .doOnTextChanged { text, _, _, _ ->
                viewModel.lastInsertedValue = text?.toString()
            }
        findViewById<Button>(R.id.aActivityBtn)
            .setOnClickListener {
                val bIntent = getIntent(this)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(bIntent)
            }

        findViewById<Button>(R.id.bActivityBtn)
            .setOnClickListener {
                val intent = ActivityB.getIntent(this)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }

        findViewById<Button>(R.id.singleTopBtn)
            .setOnClickListener {
                val intent = SingleTopActivity.getIntent(this)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }

        findViewById<Button>(R.id.singleTaskBtn)
            .setOnClickListener {
                val intent = SingleTaskActivity.getIntent(this)
                startActivity(intent)
            }

        findViewById<Button>(R.id.singleInstanceBtn)
            .setOnClickListener {
                val intent = SingleInstanceActivity.getIntent(this)
                startActivity(intent)
            }

        findViewById<Button>(R.id.singleInstancePerTaskBtn)
            .setOnClickListener {
                val intent = SingleInstancePerTaskActivity.getIntent(this)
                startActivity(intent)
            }
    }
}