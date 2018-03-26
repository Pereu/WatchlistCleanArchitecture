package com.watchlist.presentation.ui.mvp.presenters

import com.watchlist.domain.interactor.movie.MovieInteractor
import com.watchlist.domain.model.CinemaMovie
import com.watchlist.presentation.ui.mvp.views.HomeView
import javax.inject.Inject

/**
 * Created by alexanderpereu on 02.03.2018.
 */

class HomePresenter @Inject
constructor(private val movieInteractor: MovieInteractor): HomeView {
    override fun showList(list: ArrayList<CinemaMovie>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading(isLoading: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(error: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun stopLoading() {

    }
}