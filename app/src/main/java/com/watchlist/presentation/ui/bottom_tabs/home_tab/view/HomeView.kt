package com.watchlist.presentation.ui.bottom_tabs.home_tab.view

import com.watchlist.domain.model.InCinemaMovie
import com.watchlist.presentation.ui.global.view.BaseView

/**
 * Created by alexanderpereu on 02.03.2018.
 */
interface HomeView : BaseView {

    fun showList(list: InCinemaMovie)
}