package com.zhangshang.freereader.Fragment

import com.zhangshang.freereader.Bean.TabBookBean


/**
 * Created by allenlucas on 17-8-31.
 */
interface ITabPresenter {

    fun getValue(arrayList: ArrayList<TabBookBean.TabBookListBean>)
}