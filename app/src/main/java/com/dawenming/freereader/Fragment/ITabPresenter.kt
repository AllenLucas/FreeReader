package com.dawenming.freereader.Fragment

import com.dawenming.freereader.Bean.BookBean
import com.dawenming.freereader.Bean.TabBookBean

/**
 * Created by allenlucas on 17-8-31.
 */
interface ITabPresenter {

    fun getValue(arrayList: ArrayList<TabBookBean.TabBookListBean>)
}