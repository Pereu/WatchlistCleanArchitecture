package com.android.watchlist.watchlist.presentation.ui.mvp.views

import com.android.watchlist.watchlist.domain.model.User
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType


/**
 * Created by alexanderpereu on 22.01.2018.
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface LoginView : MvpView {

    fun blockButton()
    fun emailError()
    fun passwordError()
    fun emailSuccess()
    fun passwordSuccess()
    fun nameError()
    fun nameSuccess()
    fun showLoading()
    fun showSuccess(it: User)
    fun showError(it: Throwable)
}