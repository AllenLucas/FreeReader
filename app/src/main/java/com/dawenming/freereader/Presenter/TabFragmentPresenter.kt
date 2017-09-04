package com.dawenming.freereader.Presenter

import android.util.Log
import com.dawenming.freereader.Base.BasePresenter
import com.dawenming.freereader.Bean.BookBean
import com.dawenming.freereader.Bean.TabBookBean
import com.dawenming.freereader.Fragment.ITabPresenter
import com.dawenming.freereader.Model.RetrofitModel
import com.dawenming.freereader.Utils.InterfaceType
import com.google.gson.Gson

/**
 * Created by allenlucas on 17-8-31.
 */
class TabFragmentPresenter : BasePresenter<ITabPresenter>(),IBasePresenter {

    val retrofitmodel = RetrofitModel()

    override fun onSuccess(value: String, type: String) {
        val gson = Gson()
        if (type.equals(InterfaceType.BOOKLIST_URL)){
            getBookBean(gson,value)
        }
    }

    private fun getBookBean(gson: Gson, value: String) {
        val booklist = gson.fromJson(value,TabBookBean::class.java)
        if (booklist.error.equals("0")){
            //正确获取数据
            getView().getValue(booklist.msg as ArrayList<TabBookBean.TabBookListBean>)
        }else{
            //没有获取数据
        }
    }

    override fun onErro(msg: String) {
    }


    fun getBookList(num : String,cid : String){
        retrofitmodel.getBookListByType(cid,num,cid,this)
    }
}