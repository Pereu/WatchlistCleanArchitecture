package com.watchlist.presentation.ui.mvp.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.watchlist.domain.model.CinemaMovie

/**
 * Created by alexanderpereu on 02.03.2018.
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface HomeView : MvpView {

    fun showList(it: ArrayList<CinemaMovie>)
    fun showLoading(b: Boolean)
    fun showError(it: Throwable)
}