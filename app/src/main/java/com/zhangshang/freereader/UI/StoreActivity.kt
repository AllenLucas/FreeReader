package com.zhangshang.freereader.UI

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import com.zhangshang.freereader.Adapter.MyFragmentAdapter
import com.zhangshang.freereader.Adapter.StoreViewpagerAdapter
import com.zhangshang.freereader.Adapter.TabBookAdapter
import com.zhangshang.freereader.Base.BaseAcivity
import com.zhangshang.freereader.Bean.RecommendBean
import com.zhangshang.freereader.Fragment.TabFragment
import com.zhangshang.freereader.MyApplication
import com.zhangshang.freereader.Presenter.MainPresenter
import com.zhangshang.freereader.Utils.setGlideLoader
import com.zhangshang.freereader.databinding.SelectBookItemBinding
import com.google.gson.Gson
import com.zhangshang.freereader.R
import kotlinx.android.synthetic.main.activity_store.*
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class StoreActivity : BaseAcivity() ,IActivityPresenter{

    var tablayout : TabLayout? = null
    var viewpager : FrameLayout? =null
    var reclcerview : LinearLayout? =null
    val fragmentList = arrayListOf<Fragment>()
    val fmanager = supportFragmentManager
    var viewpagerlayout : LinearLayout? =null
    var recyclerview : RecyclerView? =null
    var swiplayout : SwipeRefreshLayout? = null
    val presenter : MainPresenter = MainPresenter()
    val list = arrayListOf<RecommendBean.MsgBean>()
    var adapter : TabBookAdapter<RecommendBean.MsgBean, SelectBookItemBinding>? = null
    var refrshing = false
    var loadmore = false
    var lastVisibleItem : Int? =null
    var loadmoreint = 2


    override fun getValue(gson: Gson,string: String) {
        val recommendbean = gson.fromJson(string, RecommendBean::class.java)
        if (recommendbean.error.equals("0")){
            if (refrshing){
                refrshing = false
                loadmoreint = 2
                list.clear()
                Handler().postDelayed({
                    swiplayout?.isRefreshing = false
                    list.addAll(recommendbean.msg)
                    adapter?.notifyDataSetChanged()
                },2500)
            }

            if (loadmore){
                loadmore = false
                Handler().postDelayed({
                    if (recommendbean.msg.size > 0){
                        list.addAll(recommendbean.msg)
                        adapter?.notifyItemInserted(list.size - 1)
                        loadmoreint++
                    }else if (recommendbean.msg.size == 0){
                        adapter?.changeMOreStatus(TabBookAdapter.LOAD_END)
                    }
                },2500)
            }
        }else{

        }
    }


    fun initSelectBookRecyclerView(){
        swiplayout = select_swiprefreshlayout
        swiplayout?.setColorSchemeResources(android.R.color.holo_blue_light
                ,android.R.color.holo_red_light,android.R.color.holo_orange_light
                ,android.R.color.holo_green_light)
        adapter = TabBookAdapter(this,R.layout.select_book_item)
        adapter?.setOnBindViewHolder { b, position ->
            val bean = list[position]
            val readnum = bean.read_num
            if (readnum.indexOf("人在读") == -1){
                bean.read_num = readnum + "人在读"
            }
            b.selectbook = bean
            b.root.setOnClickListener {
                BookInfoActivity.startAction(this,bean.id,bean.book_name)
            }
        }
        adapter?.initList(list)
        recyclerview?.layoutManager = GridLayoutManager(this,1)
        recyclerview?.adapter = adapter
        swiplayout?.post {
            refrshing = true
            swiplayout?.isRefreshing = true
            presenter.getRECOMMEND_URL("1")
        }
        swiplayout?.setOnRefreshListener {
            refrshing = true
            presenter.getRECOMMEND_URL("1")
        }
        recyclerview?.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!swiplayout?.isRefreshing!!){
                    adapter?.changeMOreStatus(TabBookAdapter.LOADING_MORE)
                    if (newState == 0 && lastVisibleItem!! + 1 == adapter?.itemCount){
                        loadmore = true
                        presenter.getRECOMMEND_URL(loadmoreint.toString())
                        adapter?.changeMOreStatus(TabBookAdapter.LOADING_MORE)
                    }
                }
            }

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                lastVisibleItem = (recyclerview?.layoutManager as LinearLayoutManager)
                        .findLastVisibleItemPosition()
            }
        })
    }


    fun initRecycler(){

        val viewpager = store_viewpager
        for (i in 0 until MyApplication.tabList?.size!! - 1){
            val fragment = TabFragment()
            val bundle = Bundle()
            val string = MyApplication.tabList!![i].cid
            bundle.putString("tab",string)
            fragment.arguments = bundle
            fragmentList.add(fragment)
        }
        val adapter = MyFragmentAdapter(fmanager,fragmentList)
        viewpager.adapter = adapter
        tablayout = tabLayout
        tablayout?.setupWithViewPager(viewpager)
        val list = MyApplication.tabList
        for (i in 0 until list?.size!! - 1){
            tablayout?.getTabAt(i)?.text = list[i].type
        }
    }


    fun initViewpager(){
        val viewpager = header_viewpager
        val viewgroup = header_viewpager_dot_layout
        val list = MyApplication.bannerList
        val imageViews = arrayOfNulls<ImageView>(list?.size!!)
        for (i in 0 until imageViews.size) {
            val imageView = ImageView(this)
            imageView.layoutParams = ViewGroup.LayoutParams(5, 5)
            imageViews[i] = imageView
            if (i == 0) {
                imageViews[i]?.setBackgroundResource(R.mipmap.xuanzhong)
            } else {
                imageViews[i]?.setBackgroundResource(R.mipmap.weixuanzhong)
            }
            val layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                            , LinearLayout.LayoutParams.WRAP_CONTENT))
            layoutParams.leftMargin = 5
            layoutParams.rightMargin = 5
            viewgroup.addView(imageView, layoutParams)
        }
        val mImageViews = arrayOfNulls<ImageView>(list.size)
        for (i in 0 until mImageViews.size) {
            val viewpageritem = ImageView(this)
            mImageViews[i] = viewpageritem
            viewpageritem.setGlideLoader(list[i].carousel_img, this)
        }
        viewpager.adapter = StoreViewpagerAdapter(this, mImageViews)
        if (viewpager?.visibility == View.VISIBLE){
            Observable.interval(2, 4, TimeUnit.SECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        if (viewpager.currentItem == (mImageViews.size - 1)) {
                            viewpager.currentItem = 0
                        } else {
                            viewpager.currentItem = viewpager.currentItem + 1
                        }
                    }
        }

        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                if (imageViews.isNotEmpty()){
                    for (i in 0 until imageViews.size) {
                        imageViews[position]?.setBackgroundResource(R.mipmap.xuanzhong)
                        if (position != i) {
                            imageViews[i]?.setBackgroundResource(R.mipmap.weixuanzhong)
                        }
                    }
                }
            }

        })
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_dashboard -> {
                if (viewpagerlayout?.visibility == View.VISIBLE){
                    viewpagerlayout?.visibility = View.GONE
                    viewpager?.visibility = View.GONE
                    supportActionBar?.title = "精选"
                    collapsingToolbarLayout.isTitleEnabled = false
                    reclcerview?.visibility = View.VISIBLE
                    swiplayout?.visibility = View.VISIBLE
                    recyclerview?.visibility = View.VISIBLE
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                if (viewpagerlayout?.visibility == View.GONE){
                    viewpagerlayout?.visibility = View.VISIBLE
                    viewpager?.visibility = View.VISIBLE
                    supportActionBar?.title = "书城"
                    collapsingToolbarLayout.isTitleEnabled = true
                    reclcerview?.visibility = View.GONE
                    swiplayout?.visibility = View.GONE
                    recyclerview?.visibility = View.GONE
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)
        val toolbar = store_toolbar
        if (supportActionBar == null){
            toolbar.title = "精选"
            toolbar.navigationIcon = ContextCompat.getDrawable(this,R.drawable.ic_arrow_back_black_24dp)
            setSupportActionBar(toolbar)
            toolbar.setNavigationOnClickListener { finish() }
        }
        presenter.attachView(this)
        recyclerview = select_recyclerview
        viewpagerlayout = viewpager_layout
        viewpagerlayout?.visibility = View.GONE
        viewpager = header_viewpager_layout
        viewpager?.visibility = View.GONE
        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        initViewpager()
        initRecycler()
        initSelectBookRecyclerView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    companion object {
        fun startAction(context: Context){
            context.startActivity(Intent(context,StoreActivity::class.java))
        }
    }

}
