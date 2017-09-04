package com.dawenming.freereader.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by allenlucas on 17-8-31.
 */
class MyFragmentAdapter(val fm: FragmentManager?, val list : ArrayList<Fragment>) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }
}