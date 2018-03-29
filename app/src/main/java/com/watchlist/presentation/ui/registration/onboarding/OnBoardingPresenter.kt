package com.watchlist.presentation.ui.registration.onboarding

import com.watchlist.domain.interactor.movie.OnBoardingInteractor
import com.watchlist.domain.model.OnBoardingMovie
import com.watchlist.presentation.ui.global.BasePresenter
import com.watchlist.presentation.ui.registration.onboarding.view.OnBoardingView
import rx.lang.kotlin.FunctionSubscriber
import javax.inject.Inject

/**
 * Created by alexanderpereu on 02.02.2018.
 */

class OnBoardingPresenter  <V : OnBoardingView>
@Inject constructor(private val movieInteractor: OnBoardingInteractor): BasePresenter<V>() {

    private var take = 10
    private var skip = 0

    override fun viewIsReady() {
        getView()?.showLoading(true)
    }

    fun loadMovies() {
        movieInteractor.take = take
        movieInteractor.skip = skip
        skip += take
        movieInteractor.buildUseCaseObservableList(FunctionSubscriber<ArrayList<OnBoardingMovie>>()
                .onNext { getView()?.showList(it) }
                .onError { getView()?.showError(it) })
    }
}