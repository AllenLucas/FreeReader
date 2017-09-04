package com.dawenming.freereader.Base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import okhttp3.ResponseBody
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by allenlucas on 17-8-29.
 */
open class BaseAcivity : AppCompatActivity() {


    val mComPositeSubscription = CompositeSubscription()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onDestroy() {
        if (mComPositeSubscription.hasSubscriptions()){
            mComPositeSubscription.unsubscribe()
        }
        super.onDestroy()
    }

    open fun addsubscription(observable: Observable<ResponseBody>, subscriber : Subscriber<ResponseBody>){
        mComPositeSubscription.add(observable.subscribeOn(Schedulers.io())
                .onBackpressureDrop()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber))
    }
}