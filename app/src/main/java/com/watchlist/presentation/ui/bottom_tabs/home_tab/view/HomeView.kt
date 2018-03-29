package com.watchlist.presentation.ui.bottom_tabs.home_tab.view

import com.watchlist.domain.model.InCinemaMovie

/**
 * Created by alexanderpereu on 02.03.2018.
 */
interface HomeView {

    fun showList(list: InCinemaMovie)
    fun showLoading(isLoading: Boolean)
    fun showError(error: Throwable)
}