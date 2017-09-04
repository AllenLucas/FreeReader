package com.dawenming.freereader.UI

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import com.dawenming.freereader.Adapter.MyFragmentAdapter
import com.dawenming.freereader.Adapter.StoreViewpagerAdapter
import com.dawenming.freereader.Fragment.TabFragment
import com.dawenming.freereader.MyApplication
import com.dawenming.freereader.R
import com.dawenming.freereader.Utils.setGlideLoader
import kotlinx.android.synthetic.main.activity_store.*
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class StoreActivity : AppCompatActivity() {

    var tablayout : TabLayout? = null
//    var viewpagerlayout : LinearLayout? =null
    var viewpager : FrameLayout? =null
    var reclcerview : LinearLayout? =null
    val fragmentList = arrayListOf<Fragment>()
    val fmanager = supportFragmentManager
    var viewpagerlayout : LinearLayout? =null


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
        Log.e("size",list.size.toString())
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

        viewpagerlayout = viewpager_layout
        viewpagerlayout?.visibility = View.GONE
        viewpager = header_viewpager_layout
        viewpager?.visibility = View.GONE
        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        initViewpager()
        initRecycler()
    }


    companion object {
        fun startAction(context: Context){
            context.startActivity(Intent(context,StoreActivity::class.java))
        }
    }

}
