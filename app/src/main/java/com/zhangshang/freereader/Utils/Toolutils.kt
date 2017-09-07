package com.zhangshang.freereader.Utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by allenlucas on 17-8-30.
 */


fun ImageView.setGlideLoader(urlstring: String, context: Context){
    Glide.with(context).load(urlstring).centerCrop().into(this)
}