package com.zhangshang.freereader.UI

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.RelativeLayout
import com.zhangshang.freereader.Base.BaseAcivity

import com.google.gson.Gson
import com.zhangshang.freereader.Adapter.MyAdapter
import com.zhangshang.freereader.Bean.BookInfoBean
import com.zhangshang.freereader.Presenter.MainPresenter
import com.zhangshang.freereader.R
import com.zhangshang.freereader.databinding.ActivityBookInfoBinding
import kotlinx.android.synthetic.main.activity_book_info.*

class BookInfoActivity : BaseAcivity() ,IActivityPresenter{

    val presenter : MainPresenter = MainPresenter()
    var progresslayout : RelativeLayout? =null
    val otherlist = arrayListOf<BookInfoBean.OtherBean>()
    val msgbeanlist = arrayListOf<BookInfoBean.MsgBean>()
    val similarlist = arrayListOf<BookInfoBean.SimilarBean>()
    var adapter : MyAdapter? =null
    var databinding : ActivityBookInfoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_book_info)
//        setContentView(R.layout.activity_book_info)
        val toolbar = bookinfo_toolbar
        val bundle = intent.getBundleExtra("bundle")
        val bookid = bundle.getString("bookid")
        val bookname = bundle.getString("bookname")
        if (supportActionBar == null){
            toolbar.title = ""
            toolbar.navigationIcon = ContextCompat
                    .getDrawable(this,R.drawable.ic_arrow_back_black_24dp)
            setSupportActionBar(toolbar)
            toolbar.setNavigationOnClickListener { finish() }
        }
        progresslayout = progressbar_layout
        presenter.attachView(this)
        presenter.getDETAILSPAGE_URL(bookid)
        adapter = MyAdapter(this,similarlist,msgbeanlist,otherlist)
        val recyclerview = bookinfo_recyclerView
        recyclerview?.layoutManager = LinearLayoutManager(this)
        recyclerview?.adapter = adapter

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }


    override fun getValue(gson: Gson, string: String) {
        val bookinfobean = gson.fromJson(string,BookInfoBean::class.java)
        msgbeanlist.addAll(bookinfobean.msg)
        similarlist.addAll(bookinfobean.similar)
        otherlist.addAll(bookinfobean.other)
        adapter?.notifyDataSetChanged()
        if (progresslayout?.visibility == View.VISIBLE){
            Handler().postDelayed({
                progresslayout?.visibility = View.GONE
            },1000)
        }
        //                String total = headerlist.get(0).getTotal_number();
//                if (total.length() > 4){
//                    total = total.substring(0,total.length() - 4) + "万字";
//                }else {
//                    total = total + "字";
//                }
        val bookbean = bookinfobean.msg[0]
        var total = bookbean.total_number
        if (total.length > 4){
            total = total.substring(0,total.length - 4) + "万字"
        }else{
            total = total + "字"
        }
        bookbean.total_number = total
        databinding?.bookinfo = bookbean
    }

    companion object {
        fun startAction(context: Context,bookid: String,bookname : String){
            val intent = Intent(context,BookInfoActivity::class.java)
            val bundle = Bundle()
            bundle.putString("bookid",bookid)
            bundle.putString("bookname",bookname)
            intent.putExtra("bundle",bundle)
            context.startActivity(intent)
        }
    }
}
