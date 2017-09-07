package com.zhangshang.freereader.Presenter

import com.zhangshang.freereader.Base.BasePresenter
import com.google.gson.Gson
import com.zhangshang.freereader.Bean.TabBookBean
import com.zhangshang.freereader.Fragment.ITabPresenter
import com.zhangshang.freereader.Model.RetrofitModel
import com.zhangshang.freereader.Utils.InterfaceType

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
        val booklist = gson.fromJson(value, TabBookBean::class.java)
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