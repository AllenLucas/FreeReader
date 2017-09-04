package com.dawenming.freereader.Presenter

import android.util.Log
import com.dawenming.freereader.Base.BaseAcivity
import com.dawenming.freereader.Base.BasePresenter
import com.dawenming.freereader.Bean.BannerBean
import com.dawenming.freereader.Bean.TabBean
import com.dawenming.freereader.Model.RetrofitModel
import com.dawenming.freereader.MyApplication
import com.dawenming.freereader.Utils.InterfaceType
import com.google.gson.Gson

/**
 * Created by allenlucas on 17-8-30.
 */
class MainPresenter :BasePresenter<BaseAcivity>() ,IBasePresenter{

    val retrofitmodel = RetrofitModel()
    override fun onSuccess(value: String,type : String) {
        val gson = Gson()
        when(type){
            InterfaceType.CAROUSEL_URL -> getCarousel(gson, value)
            InterfaceType.IFICATION_URL -> getIfication(gson, value)
        }

    }

    fun getCarousel(gson: Gson,value: String){
        val bannerbean = gson.fromJson(value,BannerBean::class.java)
        if (bannerbean.error.equals("0")){
            //正确获取数据
            MyApplication.bannerList = bannerbean.data as ArrayList<BannerBean.Banner>?
        }else{
            //没有获取到数据
        }
    }

    fun getIfication(gson: Gson,value: String){
        val tabbean = gson.fromJson(value,TabBean::class.java)
        if (tabbean.error.equals("0")){
            MyApplication.tabList = tabbean.msg as ArrayList<TabBean.MsgBean>?
        }else{

        }
    }

    override fun onErro(msg : String) {
        Log.e("onerro",msg)
    }


    fun getCAROUSEL_URL(){
        retrofitmodel.getBanner("carousel",this)
    }

    fun getIFICATION_URL(){
        retrofitmodel.getTabName("ification",this)
    }


}