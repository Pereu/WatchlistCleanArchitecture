package com.watchlist.presentation.ui.mvp.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by alexanderpereu on 23.01.2018.
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface RegistrationView : MvpView {
}