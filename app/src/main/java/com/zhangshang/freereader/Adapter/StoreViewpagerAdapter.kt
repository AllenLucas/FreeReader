package com.zhangshang.freereader.Adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

/**
 * Created by allenlucas on 17-8-30.
 */
class StoreViewpagerAdapter(val context: Context, val list: Array<ImageView?>) : PagerAdapter(){

    var json : String? =null

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        (container as ViewPager).removeView(list[position])
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): ImageView? {
        val imageview = list[position]
        val parent = imageview?.parent
        if (parent !=null){
            parent as ViewGroup
            parent.removeView(imageview)
        }
        (container as ViewPager).addView(list[position],0)
        return list[position]
    }
}