package com.zhangshang.freereader.UI

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.zhangshang.freereader.R

import com.zhangshang.freereader.UI.MainActivity

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
