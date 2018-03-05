package com.watchlist.presentation.ui.global

import android.content.Context
import android.net.ConnectivityManager
import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpAppCompatFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by alexanderpereu on 02.03.2018.
 */
abstract class BaseSupportFragment : MvpAppCompatFragment(), HasSupportFragmentInjector {

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
    

//    override fun fragmentInjector(): AndroidInjector<Fragment> {
//        return childFragmentInjector
//    }


    fun checkInternet() : Boolean {
        val cm = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null
    }
}