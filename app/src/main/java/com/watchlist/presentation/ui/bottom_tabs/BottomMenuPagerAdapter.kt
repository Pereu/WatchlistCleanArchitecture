package com.watchlist.presentation.ui.bottom_tabs

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.watchlist.presentation.ui.bottom_tabs.account_tab.AccountTabFragment
import com.watchlist.presentation.ui.bottom_tabs.home_tab.view.HomeTabFragment
import com.watchlist.presentation.ui.bottom_tabs.search_tab.SearchTabFragment
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