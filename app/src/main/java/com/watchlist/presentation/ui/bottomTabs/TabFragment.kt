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

    private var bottomNavigationItems = ArrayList<AHBottomNavigationItem>()
    private var adapter: BottomMenuPagerAdapter? = null
    private var fragment: Fragment? = null
    private var isLoad = false
    private var tabview: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if(tabview == null){
            tabview = inflater.inflate(R.layout.fragment_tab, container, false)
        }

        return tabview

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if(!isLoad) {
            isLoad = true
            initBottomMenu()
        }
    }

    private fun initBottomMenu() {
        val home = AHBottomNavigationItem(R.string.home_tab, R.drawable.home_outline, R.color.colorAccent)
        val search = AHBottomNavigationItem(R.string.search_tab, R.drawable.magnify, R.color.colorAccent)
        val account = AHBottomNavigationItem(R.string.account_tab, R.drawable.account_outline, R.color.colorAccent)

        bottomNavigationItems.add(home)
        bottomNavigationItems.add(search)
        bottomNavigationItems.add(account)

        adapter = childFragmentManager.let { BottomMenuPagerAdapter(it) }
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

    override fun onResume() {
        super.onResume()
        val i  = 0
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val i  = 0
    }

    override fun onDestroy() {
        super.onDestroy()
        val i  = 0
    }

}