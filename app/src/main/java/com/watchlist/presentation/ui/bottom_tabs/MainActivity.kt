package com.watchlist.presentation.ui.bottom_tabs

import android.os.Bundle
import android.support.v4.app.Fragment
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.watchlist.R
import com.watchlist.presentation.ui.global.view.BaseActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : DaggerAppCompatActivity(), AHBottomNavigation.OnTabSelectedListener {

    private val bottomNavigationItems = ArrayList<AHBottomNavigationItem>()
    private lateinit var adapter: BottomMenuPagerAdapter
    private var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomMenu()
    }

    private fun initBottomMenu() {
        val home = AHBottomNavigationItem(R.string.home_tab, R.drawable.home_outline, R.color.colorAccent)
        val search = AHBottomNavigationItem(R.string.search_tab, R.drawable.magnify, R.color.colorAccent)
        val account = AHBottomNavigationItem(R.string.account_tab, R.drawable.account_outline, R.color.colorAccent)

        bottomNavigationItems.add(home)
        bottomNavigationItems.add(search)
        bottomNavigationItems.add(account)

        adapter = BottomMenuPagerAdapter(supportFragmentManager)
        activity_main_view_pager.adapter = adapter

        fragment = adapter.getItem(0)

        with(activity_main_navigation) {
            setOnTabSelectedListener(this@MainActivity)
            addItems(bottomNavigationItems)
            defaultBackgroundColor = resources.getColor(R.color.colorWhite)
            accentColor = resources.getColor(R.color.colorAccent)
            titleState = AHBottomNavigation.TitleState.ALWAYS_SHOW
            isBehaviorTranslationEnabled = false
        }

        activity_main_view_pager.offscreenPageLimit = 2

    }

    override fun onTabSelected(position: Int, wasSelected: Boolean): Boolean {
        activity_main_view_pager.setCurrentItem(position, false)
        return true
    }
}
