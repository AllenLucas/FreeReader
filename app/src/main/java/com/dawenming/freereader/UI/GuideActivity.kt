package com.dawenming.freereader.UI

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import com.dawenming.freereader.R

class GuideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        Handler().postDelayed({
            MainActivity.startAction(this)
            finish()
        },3000)
    }
}
