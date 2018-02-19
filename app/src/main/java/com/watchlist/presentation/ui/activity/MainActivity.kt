package com.watchlist.presentation.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.watchlist.R
import com.watchlist.presentation.ui.adapters.BottomMenuPagerAdapter
import com.watchlist.presentation.ui.fragments.MainTabFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), AHBottomNavigation.OnTabSelectedListener {

    private val bottomNavigationItems = ArrayList<AHBottomNavigationItem>()
    private var adapter: BottomMenuPagerAdapter? = null
    private var fragment: MainTabFragment? = null

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

        fragment = adapter?.getItem(0)

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
        if (fragment == null) {
            fragment = adapter?.getItem(position)
            return true
        }
        activity_main_view_pager.setCurrentItem(position, false)
        return true
    }
}
