package com.watchlist.presentation.ui.bottomTabs

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.watchlist.presentation.ui.bottomTabs.accountTab.AccountTabFragment
import com.watchlist.presentation.ui.bottomTabs.homeTab.view.HomeTabFragment
import com.watchlist.presentation.ui.bottomTabs.search_tab.SearchTabFragment
import java.util.*

/**
 * Created by alexanderpereu on 19.02.2018.
 */
class BottomMenuPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragments = ArrayList<Fragment>()

    init {
        with(fragments) {
            clear()
            add(HomeTabFragment())
            add(SearchTabFragment())
            add(AccountTabFragment())
        }
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}