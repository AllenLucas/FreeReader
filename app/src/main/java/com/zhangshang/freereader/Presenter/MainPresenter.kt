package com.zhangshang.freereader.Presenter

import android.util.Log
import com.zhangshang.freereader.Base.BasePresenter
import com.google.gson.Gson
import com.zhangshang.freereader.Bean.BannerBean
import com.zhangshang.freereader.Bean.TabBean
import com.zhangshang.freereader.Model.RetrofitModel
import com.zhangshang.freereader.MyApplication
import com.zhangshang.freereader.UI.IActivityPresenter
import com.zhangshang.freereader.Utils.InterfaceType

/**
 * Created by allenlucas on 17-8-30.
 */
class MainPresenter :BasePresenter<IActivityPresenter>() ,IBasePresenter{

    val retrofitmodel = RetrofitModel()
    override fun onSuccess(value: String,type : String) {
        val gson = Gson()
        when(type){
            InterfaceType.CAROUSEL_URL -> getCarousel(gson, value)
            InterfaceType.IFICATION_URL -> getIfication(gson, value)
            InterfaceType.RECOMMEND_URL -> getValueByString(gson,value)
            InterfaceType.DETAILSPAGE_URL -> getValueByString(gson,value)
            InterfaceType.SEARCH_URL -> getValueByString(gson,value)
        }

    }


    fun getValueByString(gson: Gson,value: String){
        getView().getValue(gson,value)
    }

    fun getCarousel(gson: Gson,value: String){
        val bannerbean = gson.fromJson(value, BannerBean::class.java)
        if (bannerbean.error.equals("0")){
            //正确获取数据
            MyApplication.bannerList = bannerbean.data as ArrayList<BannerBean.Banner>?
        }else{
            //没有获取到数据
        }
    }

    fun getIfication(gson: Gson,value: String){
        val tabbean = gson.fromJson(value, TabBean::class.java)
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

    fun getRECOMMEND_URL(num : String){
        retrofitmodel.getRecommend("recommend",num,this)
    }


    fun getDETAILSPAGE_URL(bookid:String){
        retrofitmodel.getDetailspage("detailspage",bookid,this)
    }

    fun getSEARCH_URL(key : String){
        retrofitmodel.getSearch("key","1",key,this,InterfaceType.SEARCH_URL)
    }


}