package com.zhangshang.freereader

import android.app.Application
import com.zhangshang.freereader.Bean.BannerBean
import com.zhangshang.freereader.Bean.TabBean

/**
 * Created by allenlucas on 17-8-29.
 */
object MyApplication : Application(){


    var bannerList : ArrayList<BannerBean.Banner>? = null
    var tabList : ArrayList<TabBean.MsgBean>? =null

    override fun onCreate() {
        super.onCreate()
    }
}