package com.watchlist.presentation.ui.bottomTabs

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.watchlist.R
import kotlinx.android.synthetic.main.fragment_tab.*
import java.util.*

class TabFragment : Fragment(), AHBottomNavigation.OnTabSelectedListener {

    private val bottomNavigationItems = ArrayList<AHBottomNavigationItem>()
    private var adapter: BottomMenuPagerAdapter? = null
    private var fragment: Fragment? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initBottomMenu()
    }

    private fun initBottomMenu() {
        val home = AHBottomNavigationItem(R.string.home_tab, R.drawable.home_outline, R.color.colorAccent)
        val search = AHBottomNavigationItem(R.string.search_tab, R.drawable.magnify, R.color.colorAccent)
        val account = AHBottomNavigationItem(R.string.account_tab, R.drawable.account_outline, R.color.colorAccent)

        bottomNavigationItems.add(home)
        bottomNavigationItems.add(search)
        bottomNavigationItems.add(account)

        adapter = fragmentManager?.let { BottomMenuPagerAdapter(it) }
        fragment_main_view_pager.adapter = adapter

        fragment = adapter?.getItem(0)

        with(fragment_main_navigation) {
            setOnTabSelectedListener(this@TabFragment)
            addItems(bottomNavigationItems)
            defaultBackgroundColor = ContextCompat.getColor(context, R.color.colorWhite)
            accentColor = ContextCompat.getColor(context, R.color.colorAccent)
            titleState = AHBottomNavigation.TitleState.ALWAYS_SHOW
            isBehaviorTranslationEnabled = false
        }

        fragment_main_view_pager.offscreenPageLimit = 2

    }

    override fun onTabSelected(position: Int, wasSelected: Boolean): Boolean {
        fragment_main_view_pager.setCurrentItem(position, true)
        return true
    }
}