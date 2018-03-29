package com.watchlist.presentation.ui.registration.onboarding.view

import com.watchlist.domain.model.OnBoardingMovie
import com.watchlist.presentation.ui.global.view.BaseView

/**
 * Created by alexanderpereu on 02.02.2018.
 */

interface OnBoardingView : BaseView {

    fun showList(list: ArrayList<OnBoardingMovie>)
}