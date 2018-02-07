package com.watchlist.presentation.routing

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.watchlist.R
import com.watchlist.presentation.extension.*


/**
 * Created by alexanderpereu on 22.01.2018.
 */

class Router (private val activity: AppCompatActivity) {

    //add fragment
    fun addFragment (fragment: Fragment, container: Int) {
       activity.addFragment(fragment,  container)
    }

    //replace existing fragment
    fun replaceFragment(fragment: Fragment, container: Int){
        activity.replaceFragment(fragment, container)
    }

    //remove it fragment
    fun remove(fragment: Fragment) {
        activity.removeFragment(fragment)
    }

    //backPressed
    fun backPressed() {
        activity.backPressed()
    }

    //pops every fragment and starts the given fragment as a new one
    fun addFragmentAsRoot(fragment: Fragment, container: Int) {
        activity.clearAllBackStack()
        activity.addFragment(fragment, container)
    }
}


