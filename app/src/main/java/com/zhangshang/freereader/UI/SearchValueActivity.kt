package com.zhangshang.freereader.UI

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.zhangshang.freereader.Adapter.SearchAdapter
import com.zhangshang.freereader.Base.BaseAcivity
import com.zhangshang.freereader.Bean.SearchValueBean
import com.zhangshang.freereader.Presenter.MainPresenter

import com.google.gson.Gson
import com.zhangshang.freereader.R
import kotlinx.android.synthetic.main.activity_search_value.*

class SearchValueActivity : BaseAcivity() ,IActivityPresenter{


    val presenter : MainPresenter = MainPresenter()
    val datalist = arrayListOf<SearchValueBean.DataBean>()
    val similarlist = arrayListOf<SearchValueBean.SimilarBean>()
    var adapter : SearchAdapter? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        val bundle = intent.getBundleExtra("bundle")
        val key = bundle.getString("key")
        setContentView(R.layout.activity_search_value)
        if (supportActionBar == null){
            searchvalue_toolbar.title = "搜索"+key
            setSupportActionBar(searchvalue_toolbar)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        presenter.attachView(this)
        presenter.getSEARCH_URL(key)
        val recyclerview = searchvalue_recyclerview
        recyclerview.layoutManager = LinearLayoutManager(this)
        adapter = SearchAdapter(this,datalist,similarlist)
        recyclerview.adapter = adapter
    }

    override fun getValue(gson: Gson, string: String) {
        val bean = gson.fromJson(string,SearchValueBean::class.java)
        datalist.addAll(bean.data)
        similarlist.addAll(bean.similar)
        adapter?.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == android.R.id.home){
            this.finish()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun startAction(context: Context,key : String){
            val intent = Intent(context,SearchValueActivity::class.java)
            val bundle = Bundle()
            bundle.putString("key",key)
            intent.putExtra("bundle",bundle)
            context.startActivity(intent)
        }
    }
}
