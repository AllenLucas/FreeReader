package com.zhangshang.freereader.Model

import com.zhangshang.freereader.Presenter.IBasePresenter


/**
 * Created by allenlucas on 17-8-30.
 */
interface IRetrofitModel {

    fun getSearch(key : String, num : String, searchword :String, activity: IBasePresenter, type:String)

    fun getBanner(key: String,activity: IBasePresenter)

    fun getTabName(key: String,activity: IBasePresenter)

    fun getBookListByType(key: String,num: String,cid :String,activity: IBasePresenter)

    fun getRecommend(key: String,num: String,activity: IBasePresenter)

    fun getDetailspage(key: String,id :String,activity: IBasePresenter)
}