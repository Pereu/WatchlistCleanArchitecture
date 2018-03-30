package com.watchlist.presentation.ui.bottom_tabs.home_tab

import com.watchlist.domain.interactor.movie.InCinemaInteractor
import com.watchlist.domain.model.InCinemaMovie
import com.watchlist.presentation.ui.bottom_tabs.home_tab.view.HomeView
import com.watchlist.presentation.ui.global.BasePresenter
import rx.lang.kotlin.FunctionSubscriber
import javax.inject.Inject

/**
 * Created by alexanderpereu on 02.03.2018.
 */

class HomePresenter<V : HomeView>
@Inject
constructor(private val movieInteractor: InCinemaInteractor) : BasePresenter<V>() {


    private var take = 10
    private var skip = 0

    override fun viewIsReady() {
        getCinemaMovie()
    }

    private fun getCinemaMovie() {
        movieInteractor.take = take
        movieInteractor.skip = skip
        skip += take
        movieInteractor.buildUseCaseObservableObject(FunctionSubscriber<InCinemaMovie>()
                .onNext { getView()?.showList(it) }
                .onError { getView()?.showError(it) } )
    }

    override fun viewIsGone() {
        movieInteractor.unsubscribe()
    }
}