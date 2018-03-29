package com.watchlist.presentation.ui.global.view

import android.content.Context
import android.net.ConnectivityManager
import dagger.android.support.DaggerFragment

/**
 * Created by alexanderpereu on 02.03.2018.
 */

abstract class BaseSupportFragment : DaggerFragment() {

    fun checkInternet() : Boolean {
        val cm = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null
    }
}