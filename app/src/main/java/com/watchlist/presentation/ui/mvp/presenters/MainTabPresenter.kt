package com.watchlist.presentation.ui.mvp.presenters

import android.support.v7.app.AppCompatActivity
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.watchlist.presentation.routing.Router
import com.watchlist.presentation.ui.fragments.AccountTabFragment
import com.watchlist.presentation.ui.fragments.HomeTabFragment
import com.watchlist.presentation.ui.fragments.SearchTabFragment
import com.watchlist.presentation.ui.mvp.views.MainTabView

/**
 * Created by alexanderpereu on 20.02.2018.
 */
@InjectViewState
class MainTabPresenter : MvpPresenter<MainTabView>() {

    fun showCurrentFragment(index: Int, activity: AppCompatActivity, container: Int) {
        when (index) {
            0 -> {
                val router = Router(activity)
                router.addFragment(HomeTabFragment(), container)
            }
            1 -> {
                val router = Router(activity)
                router.addFragment(SearchTabFragment(), container)
            }
            2 -> {
                val router = Router(activity)
                router.addFragment(AccountTabFragment(), container)
            }
        }
    }

}