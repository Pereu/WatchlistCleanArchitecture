package com.watchlist.presentation.ui.bottom_tabs.home_tab.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.watchlist.R
import com.watchlist.domain.model.Item
import kotlinx.android.synthetic.main.item_home.view.*

/**
 * Created by alexandr on 26/03/2018.
 */

class SlideViewPagerAdapter : PagerAdapter() {

    private var images = arrayListOf<Item>()

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return images.size
    }

    @SuppressLint("InflateParams")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = container.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view  = inflater.inflate(R.layout.item_home, null)

        val index = images[position].Backdrops.size - 3

        Glide.with(view.context)
                .load(images[position].Backdrops[index].Url)
                .into(view.item_home_in_cinema_image)

        val vp = container as ViewPager
        vp.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }

    fun setList (list: ArrayList<Item>) {
        this.images.addAll(list)
        notifyDataSetChanged()
    }
}