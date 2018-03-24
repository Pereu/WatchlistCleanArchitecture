package com.watchlist.presentation.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.watchlist.R
import com.watchlist.domain.model.CinemaMovie
import com.watchlist.presentation.ui.mvp.presenters.HomePresenter
import com.watchlist.presentation.ui.mvp.views.HomeView
import javax.inject.Inject

/**
 * Created by alexanderpereu on 20.02.2018.
 */
class HomeTabFragment : Fragment(), HomeView {


    @Inject
    @InjectPresenter
    lateinit var presenter: HomePresenter

    @ProvidePresenter
    fun provideHomePresenter(): HomePresenter {
        return presenter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_tab_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun showList(it: ArrayList<CinemaMovie>) {

    }

    override fun showLoading(b: Boolean) {
    }

    override fun showError(it: Throwable) {
    }

}