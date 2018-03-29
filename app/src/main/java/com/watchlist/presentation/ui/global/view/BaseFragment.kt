package com.watchlist.presentation.ui.global.view

import android.content.Context
import android.net.ConnectivityManager
import dagger.android.DaggerFragment

/**
 * Created by alexanderpereu on 23.01.2018.
 */
abstract class BaseFragment : DaggerFragment() {

    fun checkInternet() : Boolean {
         val cm = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
         return cm.activeNetworkInfo != null
    }
}