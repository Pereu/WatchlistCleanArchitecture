package com.watchlist.presentation.ui.bottom_tabs.home_tab.view

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.pawegio.kandroid.longToast
import com.watchlist.R
import com.watchlist.domain.model.InCinemaMovie
import com.watchlist.presentation.extension.addParams
import com.watchlist.presentation.extension.changePosition
import com.watchlist.presentation.ui.bottom_tabs.home_tab.HomePresenter
import com.watchlist.presentation.ui.bottom_tabs.home_tab.adapter.SlideViewPagerAdapter
import com.watchlist.presentation.ui.global.view.BaseSupportFragment
import kotlinx.android.synthetic.main.fragment_tab_home.*
import javax.inject.Inject

/**
 * Created by alexanderpereu on 20.02.2018.
 */

class HomeTabFragment : BaseSupportFragment(), HomeView {

    @Inject
    lateinit var presenter: HomePresenter<HomeView>

    private var adapter: SlideViewPagerAdapter? = null

    private var dotsCount: Int = 0
    private var dots = arrayListOf<ImageView>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater.inflate(R.layout.fragment_tab_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        adapter = SlideViewPagerAdapter()
        fragment_home_view_pager.adapter = adapter
        fragment_home_view_pager.changePosition {
            for (i in 0 until dotsCount) {
                setNonActiveDotes(i)
            }
            setActiveDotes(it)
        }
    }

    override fun showList(list: InCinemaMovie) {
        fragment_home_progress_bar.visibility = View.GONE
        adapter?.setList(list.Items)
        fillDotes()
    }

    override fun showLoading(isLoading: Boolean) {
    }

    override fun showError(errorMessage: String) {
        longToast(errorMessage)
    }

    override fun showMessage(message: String) {
    }

    private fun fillDotes() {
        dotsCount = adapter?.count ?: 0
        for (i in 0 until dotsCount) {
            dots.add(i, ImageView(context))
            setNonActiveDotes(i)

            fragment_home_dotes_container?.addView(dots[i], addParams())
        }
        setActiveDotes(0)
    }

    private fun setNonActiveDotes (position: Int) {
        dots[position].setImageDrawable(context?.let { ContextCompat.getDrawable(it, R.drawable.non_active_dot) })
    }

    private fun setActiveDotes (position: Int) {
        dots[position].setImageDrawable(context?.let { ContextCompat.getDrawable(it, R.drawable.active_dot) })
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}