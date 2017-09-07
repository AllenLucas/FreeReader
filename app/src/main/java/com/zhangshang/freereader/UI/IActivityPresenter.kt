package com.zhangshang.freereader.UI

import com.google.gson.Gson

/**
 * Created by allenlucas on 17-9-4.
 */
interface IActivityPresenter {
    fun getValue(gson: Gson,string: String)
}