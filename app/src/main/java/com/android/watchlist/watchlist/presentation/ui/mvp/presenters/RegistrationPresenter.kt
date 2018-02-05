package com.android.watchlist.watchlist.presentation.ui.mvp.presenters

import com.android.watchlist.watchlist.presentation.routing.Router
import com.android.watchlist.watchlist.presentation.ui.fragments.LoginFragment
import com.android.watchlist.watchlist.presentation.ui.global.BaseActivity
import com.android.watchlist.watchlist.presentation.ui.mvp.views.RegistrationView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

/**
 * Created by alexanderpereu on 22.01.2018.
 */
@InjectViewState
class RegistrationPresenter : MvpPresenter<RegistrationView>() {

    fun viewIsReady(activity: BaseActivity, layout: Int) {
        val router = Router(activity)
        router.addFragment(LoginFragment(), layout)
    }

    fun back(activity: BaseActivity) {
       val router = Router(activity)
        router.backPressed()
    }


}