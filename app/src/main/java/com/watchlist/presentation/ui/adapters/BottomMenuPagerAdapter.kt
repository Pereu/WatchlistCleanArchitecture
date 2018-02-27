package com.watchlist.presentation.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.watchlist.presentation.ui.fragments.AccountTabFragment
import com.watchlist.presentation.ui.fragments.HomeTabFragment
import com.watchlist.presentation.ui.fragments.SearchTabFragment
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