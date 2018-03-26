package com.watchlist.presentation.ui.mvp.views

import com.arellomobile.mvp.MvpView
import com.watchlist.domain.model.CinemaMovie

/**
 * Created by alexanderpereu on 02.03.2018.
 */
interface HomeView : MvpView {

    fun showList(list: ArrayList<CinemaMovie>)
    fun showLoading(isLoading: Boolean)
    fun showError(error: Throwable)
}