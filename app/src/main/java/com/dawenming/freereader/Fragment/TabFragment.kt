package com.dawenming.freereader.Fragment

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dawenming.freereader.Adapter.TabBookAdapter
import com.dawenming.freereader.Bean.TabBookBean
import com.dawenming.freereader.Presenter.TabFragmentPresenter
import com.dawenming.freereader.R
import com.dawenming.freereader.databinding.TablistItemBinding

/**
 * Created by allenlucas on 17-8-31.
 */
class TabFragment : Fragment() ,ITabPresenter{


    var presenter : TabFragmentPresenter? =null
    val list = arrayListOf<TabBookBean.TabBookListBean>()
    var adapter : TabBookAdapter<TabBookBean.TabBookListBean,TablistItemBinding>? =null
    var swiplayout : SwipeRefreshLayout? = null
    var refrshing = false
    var loadmore = false
    var tabname : String? =null
    var loadmoreint = 2


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.tab_fragment,container,false)
        presenter = TabFragmentPresenter()
        presenter?.attachView(this)
        val recyclerview = view?.findViewById<RecyclerView>(R.id.recyclerview)
        swiplayout = view?.findViewById<SwipeRefreshLayout>(R.id.swiperefreshlayout)
        val bundle = arguments
        tabname = bundle.getString("tab")
        swiplayout?.post {
            refrshing = true
            adapter?.changeMOreStatus(TabBookAdapter.START_ACTION)
            swiplayout?.isRefreshing = true
            if (bundle !=null){
                presenter?.getBookList("1",tabname!!)
            }
        }
        swiplayout?.setColorSchemeResources(android.R.color.holo_blue_light
                ,android.R.color.holo_red_light,android.R.color.holo_orange_light
                ,android.R.color.holo_green_light)
        adapter = TabBookAdapter(context,R.layout.tablist_item)
        recyclerview?.layoutManager = GridLayoutManager(context,1)
        adapter?.setOnBindViewHolder { b, position ->
            val bookbean = list[position]
            if (bookbean.total_number.length > 4){
                bookbean.total_number =
                        bookbean.total_number.substring(0,bookbean.total_number.length - 4) + "万字"
            }
            b.book = bookbean
        }
        adapter?.initList(list)
        recyclerview?.adapter = adapter

        swiplayout?.setOnRefreshListener {
            refrshing = true
//            adapter?.changeMOreStatus(TabBookAdapter.LOADING_MORE)
            presenter?.getBookList("1",tabname!!)
        }

        initRecyclerView(recyclerview)

        return view
    }

    var lastVisibleItem : Int? =null
    private fun initRecyclerView(recyclerview: RecyclerView?) {
        recyclerview?.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                lastVisibleItem = (recyclerView?.layoutManager as LinearLayoutManager)
                        .findLastVisibleItemPosition()
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!swiplayout?.isRefreshing!!){
                    adapter?.changeMOreStatus(TabBookAdapter.LOADING_MORE)
                    if (newState == 0 && lastVisibleItem!! + 1 == adapter?.itemCount){

                        loadmore = true
                        presenter?.getBookList(loadmoreint.toString(),tabname!!)
                        adapter?.changeMOreStatus(TabBookAdapter.LOADING_MORE)
//                    Handler().postDelayed({  },2500)
                    }
                }

            }
        })
    }


    override fun getValue(arrayList: ArrayList<TabBookBean.TabBookListBean>) {
        if (refrshing){
            refrshing = false
            loadmoreint = 2
            Handler().postDelayed({
                swiplayout?.isRefreshing = false
                if (arrayList.size > 0){
                    list.clear()
                    list.addAll(arrayList)
                }
                adapter?.notifyDataSetChanged()
            },2500)
        }
        if (loadmore){
            loadmore = false
            Handler().postDelayed({
                if (arrayList.size > 0){
                    list.addAll(arrayList)
                    adapter?.notifyItemInserted(list.size - 1)
                    loadmoreint++
                }else if (arrayList.size == 0){
                    adapter?.changeMOreStatus(TabBookAdapter.LOAD_END)
                }
            },2500)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        list.clear()
    }

    override fun onDestroy() {
//        presenter?.detachView()
        super.onDestroy()
    }
}