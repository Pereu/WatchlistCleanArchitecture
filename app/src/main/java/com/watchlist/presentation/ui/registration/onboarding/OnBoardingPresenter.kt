package com.watchlist.presentation.ui.registration.onboarding

import com.watchlist.domain.interactor.movie.OnBoardingInteractor
import com.watchlist.presentation.ui.global.BasePresenter
import com.watchlist.presentation.ui.registration.onboarding.view.OnBoardingView
import javax.inject.Inject

/**
 * Created by alexanderpereu on 02.02.2018.
 */

class OnBoardingPresenter  <V : OnBoardingView>
@Inject constructor(private val onBoardingInteractor: OnBoardingInteractor): BasePresenter<V>() {

    override fun viewIsReady() {
        getView()?.showLoading(true)
        loadMovies()
    }

    fun loadMovies() {
        onBoardingInteractor.getOnBoarding({getView()?.showList(it)}, {getView()?.showError(it)})
    }

    override fun viewIsGone() {}
}