package com.watchlist.presentation.ui.registration.login.view

import com.watchlist.domain.model.User
import com.watchlist.presentation.ui.global.view.BaseView

/**
 * Created by alexanderpereu on 22.01.2018.
 */

interface LoginView : BaseView {

    fun blockButton()
    fun emailError()
    fun passwordError()
    fun emailSuccess()
    fun passwordSuccess()
    fun nameError()
    fun nameSuccess()
    fun showLoading()
    fun showSuccess(it: User)
    fun showHome()
}