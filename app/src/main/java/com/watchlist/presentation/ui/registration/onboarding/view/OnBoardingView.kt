package com.watchlist.presentation.ui.registration.onboarding.view

import com.watchlist.domain.model.OnBoardingMovie
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by alexanderpereu on 02.02.2018.
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface OnBoardingView : MvpView {

    fun showList(it: ArrayList<OnBoardingMovie>)
    fun showLoading(b: Boolean)
    fun showError(it: Throwable)
}