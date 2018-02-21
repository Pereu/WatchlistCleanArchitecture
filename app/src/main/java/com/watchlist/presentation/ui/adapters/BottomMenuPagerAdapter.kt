package com.watchlist.presentation.ui.adapters


import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.watchlist.presentation.ui.fragments.MainTabFragment
import java.util.*

/**
 * Created by alexanderpereu on 19.02.2018.
 */
class BottomMenuPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragments = ArrayList<MainTabFragment>()

    init {
        fragments.clear()
        fragments.add(MainTabFragment.newInstance(0))
        fragments.add(MainTabFragment.newInstance(1))
        fragments.add(MainTabFragment.newInstance(2))
    }

    override fun getItem(position: Int): MainTabFragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}