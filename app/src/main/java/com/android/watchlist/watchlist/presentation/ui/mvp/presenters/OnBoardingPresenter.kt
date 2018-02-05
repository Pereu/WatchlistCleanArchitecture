package com.android.watchlist.watchlist.presentation.ui.mvp.presenters

import com.android.watchlist.watchlist.domain.interactor.movie.MovieInteractor
import com.android.watchlist.watchlist.domain.model.OnBoardingMovie
import com.android.watchlist.watchlist.presentation.ui.mvp.views.OnBoardingView
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

    fun viewIsReady() {
        viewState.showLoading()
        movieInteractor.buildUseCaseObservableOnBoarding(FunctionSubscriber<ArrayList<OnBoardingMovie>>()
                .onNext { viewState.showList(it) }
                .onError { viewState.showError(it) } )

    }

}