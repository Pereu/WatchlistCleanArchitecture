package com.android.watchlist.watchlist.presentation.ui.global

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by alexanderpereu on 23.01.2018.
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface BaseView : MvpView {

    fun context(): Context
    fun activity(): AppCompatActivity
}