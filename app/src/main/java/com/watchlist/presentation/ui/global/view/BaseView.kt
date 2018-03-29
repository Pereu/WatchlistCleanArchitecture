package com.watchlist.presentation.ui.global.view

/**
 * Created by alexanderpereu on 23.01.2018.
 */

interface BaseView {

    fun showLoading(isLoading: Boolean)
    fun showError(error: Throwable)
    fun showMessage(message: String)

}