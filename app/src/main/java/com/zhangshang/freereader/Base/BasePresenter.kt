package com.zhangshang.freereader.Base

import java.lang.ref.Reference
import java.lang.ref.WeakReference

/**
 * Created by allenlucas on 17-8-30.
 */
abstract class BasePresenter<T> {
    var mViewRef : Reference<T>? =null

    fun attachView(view : T){
        mViewRef = WeakReference<T>(view)
    }

    fun getView() : T{
        return mViewRef?.get()!!
    }

    fun isViewAttached() : Boolean{
        return mViewRef != null && mViewRef?.get() != null
    }

    fun detachView(){
        if (mViewRef != null){
            mViewRef?.clear()
            mViewRef = null
        }
    }

}