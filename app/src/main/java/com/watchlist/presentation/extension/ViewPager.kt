package com.watchlist.presentation.extension

import android.support.v4.view.ViewPager

fun ViewPager.changePosition(callback: (Int)->Unit){
    addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {}
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
        override fun onPageSelected(position: Int) {
            callback.invoke(position)
        }
    })
}