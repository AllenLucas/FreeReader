package com.dawenming.freereader.Presenter

/**
 * Created by allenlucas on 17-8-30.
 */
interface IBasePresenter {

    fun onSuccess(value :String,type : String)

    fun onErro(msg : String)

}