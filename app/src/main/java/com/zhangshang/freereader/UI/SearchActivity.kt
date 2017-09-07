package com.zhangshang.freereader.UI

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.SearchView
import android.util.DisplayMetrics
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.zhangshang.freereader.Base.BaseAcivity

import com.zhangshang.freereader.R
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseAcivity() {

    var width : Int? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        if (supportActionBar == null){
            search_toolbar.title = "搜索"
            setSupportActionBar(search_toolbar)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val manager = windowManager
        val metics = DisplayMetrics()
        manager.defaultDisplay.getMetrics(metics)
        width = metics.widthPixels
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu,menu)
        val seachItem = menu?.findItem(R.id.search)
        val seacherView = MenuItemCompat.getActionView(seachItem) as SearchView
        seacherView.onActionViewExpanded()
        seacherView.isIconified = false
        seacherView.queryHint = "请输入搜索内容"
        seacherView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                SearchValueActivity.startAction(this@SearchActivity,query!!)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.e("onQueryTextChange",newText)
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == android.R.id.home){
            this.finish()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun startAction(context: Context){
            context.startActivity(Intent(context,SearchActivity::class.java))
        }
    }
}
