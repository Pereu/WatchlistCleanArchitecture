package com.android.watchlist.watchlist.presentation.ui.mvp.views

import com.android.watchlist.watchlist.domain.model.OnBoardingMovie
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by alexanderpereu on 02.02.2018.
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface OnBoardingView : MvpView {

    fun showList(it: ArrayList<OnBoardingMovie>)
    fun showLoading()
    fun showError(it: Throwable)
}