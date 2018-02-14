package com.watchlist.presentation.ui.mvp.presenters

import com.watchlist.domain.interactor.movie.MovieInteractor
import com.watchlist.domain.model.OnBoardingMovie
import com.watchlist.presentation.ui.mvp.views.OnBoardingView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import rx.lang.kotlin.FunctionSubscriber
import javax.inject.Inject

/**
 * Created by alexanderpereu on 02.02.2018.
 */
@InjectViewState
class OnBoardingPresenter
@Inject
constructor(private val movieInteractor: MovieInteractor): MvpPresenter<OnBoardingView>() {

    private var take = 10
    private var skip = 0

    fun viewIsReady() {
        viewState.showLoading(true)
    }

    fun loadMovies(){
        movieInteractor.take = take
        movieInteractor.skip = skip
        skip += take
        movieInteractor.buildUseCaseObservableOnBoarding(FunctionSubscriber<ArrayList<OnBoardingMovie>>()
                .onNext { viewState.showList(it) }
                .onError { viewState.showError(it) } )
    }
}