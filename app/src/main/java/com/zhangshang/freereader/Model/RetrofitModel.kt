package com.zhangshang.freereader.Model

import com.google.gson.Gson
import com.zhangshang.freereader.Presenter.IBasePresenter
import com.zhangshang.freereader.Utils.InterfaceType
import com.zhangshang.freereader.Utils.MD5
import com.zhangshang.freereader.Utils.Retrofit.ApiClient
import com.zhangshang.freereader.Utils.Retrofit.ApicCallback
import okhttp3.RequestBody
import okhttp3.ResponseBody
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by allenlucas on 17-8-30.
 */
class RetrofitModel : IRetrofitModel{
    override fun getSearch(key: String, num: String, searchword: String, activity : IBasePresenter, type:String) {
        val keyMD5 = MD5.getMessageDigest(key.toByteArray())
        var json = "null"
        addsubscription(
                ApiClient.retrofit().getVulaeBySEARCH_URL(keyMD5,num,searchword)
                ,object : ApicCallback(){
            override fun onSuccess(model: ResponseBody) {
                json = model.string()
            }

            override fun onFailure(msg: String) {
                activity.onErro(msg)
            }

            override fun onFinish() {
                activity.onSuccess(json,type)
            }

        })
    }


    override fun getDetailspage(key: String, id: String, activity: IBasePresenter) {
        val keyMD5 = MD5.getMessageDigest(key.toByteArray())
        val map = hashMapOf<String,String>()
        map.put("key",keyMD5)
        map.put("id",id)
        val body = getBody(map)
        val apiStores = ApiClient.retrofit()
        getRequest(activity,apiStores.getVulaeByDETAILSPAGE_URL(body), InterfaceType.DETAILSPAGE_URL)
    }

    override fun getRecommend(key: String, num: String, activity: IBasePresenter) {
        val keyMD5 = MD5.getMessageDigest(key.toByteArray())
        val map = hashMapOf<String,String>()
        map.put("key",keyMD5)
        map.put("num",num)
        val body = getBody(map)
        val apiStores = ApiClient.retrofit()
        getRequest(activity,apiStores.getVulaeByRECOMMEND_URL(body),InterfaceType.RECOMMEND_URL)
    }


    override fun getBanner(key: String, activity: IBasePresenter) {
        val keyMD5 = MD5.getMessageDigest(key.toByteArray())
        val map = hashMapOf<String,String>()
        map.put("key",keyMD5)
        val body = getBody(map)
        val apiStores = ApiClient.retrofit()
        getRequest(activity,apiStores.getVulaeByCAROUSEL_URL(body),InterfaceType.CAROUSEL_URL)
    }

    override fun getTabName(key: String, activity: IBasePresenter) {
        val keyMD5 = MD5.getMessageDigest(key.toByteArray())
        val map = hashMapOf<String,String>()
        map.put("key",keyMD5)
        val body = getBody(map)
        val apiStores = ApiClient.retrofit()
        getRequest(activity,apiStores.getVulaeByIFICATION_URL(body),InterfaceType.IFICATION_URL)
    }

    override fun getBookListByType(key: String, num: String, cid: String, activity: IBasePresenter) {
        val keyMD5 = MD5.getMessageDigest(key.toByteArray())
        val map = hashMapOf<String,String>()
        map.put("key",keyMD5)
        map.put("num",num)
        map.put("id",cid)
        val body = getBody(map)
        val apiStores = ApiClient.retrofit()
        getRequest(activity,apiStores.getVulaeByBOOKLIST_URL(body),InterfaceType.BOOKLIST_URL)
    }

    private fun getRequest(activity: IBasePresenter,observable: Observable<ResponseBody>,type:String){
        var json = "null"
        addsubscription(
                observable
                ,object :ApicCallback(){
            override fun onSuccess(model: ResponseBody) {
                json = model.string()
            }

            override fun onFailure(msg: String) {
                activity.onErro(msg)
            }

            override fun onFinish() {
                activity.onSuccess(json,type)
            }
        }
        )
    }


    private fun getBody(map: HashMap<String, String>):RequestBody{
        val gson = Gson()
        val mapjson = gson.toJson(map)
        return RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8")
                ,mapjson)
    }



    private fun addsubscription(observable: Observable<ResponseBody>, subscriber : Subscriber<ResponseBody>){
        CompositeSubscription().add(observable.subscribeOn(Schedulers.io())
                .onBackpressureDrop()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber))
    }

}