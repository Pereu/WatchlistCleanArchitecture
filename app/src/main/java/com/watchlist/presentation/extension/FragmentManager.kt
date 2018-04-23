package com.watchlist.presentation.extension

import android.annotation.SuppressLint
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.watchlist.R

/**
 * Created by alexanderpereu on 22.01.2018.
 */

@SuppressLint("ResourceType", "CommitTransaction")
fun FragmentManager.addFragment(fragment: Fragment, container: Int){
    val fragmentTransaction = this.beginTransaction()
    fragmentTransaction.apply {
        setCustomAnimations(R.anim.slide_in_right, 0)
        add(container, fragment)
        addToBackStack(null)
        commitAllowingStateLoss()
    }
}

@SuppressLint("ResourceType", "CommitTransaction")
fun FragmentManager.replaceFragment(fragment: Fragment, container: Int){
    val fragmentTransaction = this.beginTransaction()
    fragmentTransaction.apply {
        setCustomAnimations(R.anim.slide_in_down, 0)
        addToBackStack(null)
        replace(container, fragment)
        commit()
    }

}

@SuppressLint("ResourceType", "CommitTransaction")
fun FragmentManager.replaceFragmentWithSharedTransition(fragment: Fragment, container: Int, view: View){
    val fragmentTransaction = this.beginTransaction()
    fragmentTransaction.apply {
        addSharedElement(view,  ViewCompat.getTransitionName(view))
        addToBackStack(null)
        replace(container, fragment)
        commitAllowingStateLoss()
    }

}

@SuppressLint("ResourceType", "CommitTransaction")
fun FragmentManager.removeFragment(fragment: Fragment) {
    val fragmentTransaction = this.beginTransaction()
    fragmentTransaction.apply {
        setCustomAnimations(0, R.anim.slide_out_down)
        remove(fragment)
        commit()
        popBackStack()
    }
}

fun FragmentManager.clearAllBackStack() {
    (0 until this.backStackEntryCount)
            .map { this.getBackStackEntryAt(it).id }
            .forEach { this.popBackStack(it, FragmentManager.POP_BACK_STACK_INCLUSIVE) }
}

fun FragmentManager.backPressed(activity: AppCompatActivity) {
    if (this.backStackEntryCount > 1) {
        this.popBackStack()
    } else {
        activity.finish()
    }
}