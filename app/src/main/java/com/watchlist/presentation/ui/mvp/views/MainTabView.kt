package com.watchlist.presentation.ui.mvp.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by alexanderpereu on 20.02.2018.
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface MainTabView : MvpView {
}