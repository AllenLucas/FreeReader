package com.dawenming.novelreader

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Administrator on 2017/6/9.
 */
class NetworkDetector {
    fun detector(context: Context): Boolean {
        val manager = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager ?: return false
        val networkInfo = manager.activeNetworkInfo
        if (networkInfo == null || !networkInfo.isAvailable) {
            return false
        }
        return true
    }
}