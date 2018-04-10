package com.watchlist.presentation.ui.bottomTabs.homeTab

import com.watchlist.domain.interactor.movie.InCinemaInteractor
import com.watchlist.presentation.ui.bottomTabs.homeTab.view.HomeView
import com.watchlist.presentation.ui.global.BasePresenter
import javax.inject.Inject

/**
 * Created by alexanderpereu on 02.03.2018.
 */

class HomePresenter<V : HomeView>
@Inject
constructor(private val interactor: InCinemaInteractor) : BasePresenter<V>() {

    override fun viewIsReady() {
        getCinemaMovie()
    }

    private fun getCinemaMovie() {
        interactor.getInCinemaMovies({getView()?.showList(it)}, {getView()?.showError(it)})
    }

    override fun viewIsGone() {
    }
}