package com.watchlist.presentation.ui.global

import android.app.Fragment
import android.content.Context
import com.arellomobile.mvp.MvpFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject
import android.net.ConnectivityManager

/**
 * Created by alexanderpereu on 23.01.2018.
 */
abstract class BaseFragment : MvpFragment(), HasFragmentInjector {

    @Inject lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onAttach(context: Context?) {
        AndroidInjection.inject(this)
        super.onAttach(context)
    }

    override fun fragmentInjector(): AndroidInjector<Fragment> {
        return childFragmentInjector
    }

    fun checkInternet() : Boolean {
         val cm = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
         return cm.activeNetworkInfo != null
    }
}