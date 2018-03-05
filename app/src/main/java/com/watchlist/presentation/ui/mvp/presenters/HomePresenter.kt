package com.watchlist.presentation.ui.mvp.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.watchlist.domain.interactor.movie.MovieInteractor
import com.watchlist.presentation.ui.mvp.views.HomeView
import javax.inject.Inject

/**
 * Created by alexanderpereu on 02.03.2018.
 */
@InjectViewState
class HomePresenter @Inject
constructor(private val movieInteractor: MovieInteractor): MvpPresenter<HomeView>() {

}