package com.dawenming.freereader.Utils.Retrofit

import android.util.Log
import okhttp3.ResponseBody
import retrofit2.adapter.rxjava.HttpException
import rx.Subscriber

/**
 * Created by allenlucas on 17-8-29.
 */
abstract class ApicCallback : Subscriber<ResponseBody>(){
    abstract fun onSuccess(model: ResponseBody)
    abstract fun onFailure(msg:String)
    abstract fun onFinish()
    override fun onCompleted() {
        onFinish()
    }

    override fun onError(e: Throwable?) {
        if (e is HttpException){
            val httpException = e
            val code = httpException.code()
            var msg = httpException.message()
            if (code == 504){
                msg = "网络不给力"
            }
            if (code == 502 || code == 404){
                msg = "服务器异常，请稍候重试"
            }
            Log.e("codeerro", code.toString())
            onFailure(msg)
        }else{
            onFailure(e.toString())
        }
    }

    override fun onNext(t: ResponseBody) {
        onSuccess(t)
    }
}