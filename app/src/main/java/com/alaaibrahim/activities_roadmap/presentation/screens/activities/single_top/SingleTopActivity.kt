package com.alaaibrahim.activities_roadmap.presentation.screens.activities.single_top

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.alaaibrahim.activities_roadmap.R
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.BaseActivity
import com.alaaibrahim.activities_roadmap.presentation.screens.activities.activity_b.ActivityB

class SingleTopActivity : BaseActivity() {

    companion object {
        fun getIntent(context: Context) = Intent(context, SingleTopActivity::class.java)

    }

    override val primaryTag: String = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_top)
        setListeners()
    }

    private fun setListeners() {
        findViewById<Button>(R.id.activitySingleTop_singleTop)
            .setOnClickListener {
                val intent = getIntent(this)
                startActivity(intent)
            }
        findViewById<Button>(R.id.activitySingleTop_bActivity)
            .setOnClickListener {
                val intent = ActivityB.getIntent(this)
                startActivity(intent)
            }
        findViewById<Button>(R.id.activitySingleTop_sameActivity)
            .setOnClickListener {
                val intent = getIntent(this)
                startActivity(intent)
            }
    }

}