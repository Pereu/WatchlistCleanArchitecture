package com.watchlist.presentation.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.watchlist.R
import com.watchlist.domain.model.CinemaMovie
import com.watchlist.presentation.ui.mvp.presenters.HomePresenter
import com.watchlist.presentation.ui.mvp.views.HomeView

/**
 * Created by alexanderpereu on 20.02.2018.
 */
class HomeTabFragment : Fragment(), HomeView {


    var presenter: HomePresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_tab_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun showList(list: ArrayList<CinemaMovie>) {

    }

    override fun showLoading(isLoading: Boolean) {
    }

    override fun showError(error: Throwable) {
    }

}