package com.dawenming.freereader.UI

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.dawenming.freereader.Adapter.BookListAdapter
import com.dawenming.freereader.Base.BaseAcivity
import com.dawenming.freereader.Bean.BookBean
import com.dawenming.freereader.Presenter.MainPresenter
import com.dawenming.freereader.R
import com.dawenming.freereader.databinding.ShelfItemBookBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class MainActivity : BaseAcivity() {

    var drawerlayout : DrawerLayout?= null
    var drawerToggle : ActionBarDrawerToggle? =null
    val activityWeakReference = WeakReference<BaseAcivity>(this)
    val presenter : MainPresenter = MainPresenter()
    var adapter : BookListAdapter<BookBean, ShelfItemBookBinding>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)
        initData()
    }

    fun initData() {
        val list = arrayListOf<BookBean>()
        val book = BookBean()
        book.bookname = "123"
        list.add(book)
        list.add(book)
        list.add(book)
        list.add(book)
        list.add(book)
        list.add(book)
        list.add(book)
        list.add(book)
        list.add(book)
        list.add(book)
        list.add(book)
        list.add(book)
        list.add(book)
        if (supportActionBar == null){
            toolbar.title = resources.getString(R.string.shlef)
            setSupportActionBar(toolbar)
        }
        drawerlayout = activity_main
        drawerToggle = ActionBarDrawerToggle(this,drawerlayout, R.string.app_name, R.string.app_name)
        drawerlayout?.addDrawerListener(drawerToggle!!)
        drawerToggle?.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        initReclerView(list)
        initListener()
        presenter.getCAROUSEL_URL()
        presenter.getIFICATION_URL()
    }


    fun initReclerView(list : ArrayList<BookBean>){
        val recycerView = main_recyclerview
        val layoutManager = GridLayoutManager(this,3)
        recycerView.layoutManager = layoutManager
        adapter = BookListAdapter(this, R.layout.shelf_item_book)
        adapter?.setOnBindViewHolder { b, position -> b.shelfbook = list[position] }
        adapter?.initList(list)
        recycerView.adapter = adapter
    }

    fun initListener(){
        floatbtn_menu.setClosedOnTouchOutside(true)
        floatbtn_store.setOnClickListener {
            StoreActivity.startAction(this)
            floatbtn_menu.close(true)
        }
        floatbtn_phone.setOnClickListener {
            Log.e(TAG,"phone")
        }
        floatbtn_wifi.setOnClickListener {
            Log.e(TAG,"wifi")
        }
        navigation.setNavigationItemSelectedListener { item: MenuItem ->
            val id = item.itemId
            when(id){
                R.id.navItem1 -> StoreActivity.startAction(this)
            }
            return@setNavigationItemSelectedListener false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (drawerToggle?.onOptionsItemSelected(item)!!){
            return true
        }
        val id = item?.itemId
        if (id == R.id.action_search){
            //点击进入搜索页面
            return true
        }
        if (id == R.id.action_store){
            StoreActivity.startAction(this)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        drawerToggle?.onConfigurationChanged(newConfig)
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        drawerToggle?.syncState()
    }



    companion object {
        val TAG = "MainActivity"
        fun startAction(context: Context){
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }


}
