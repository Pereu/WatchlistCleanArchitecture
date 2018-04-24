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
fun FragmentManager.addFragment(fragment: Fragment, container: Int) {
    val tag = fragment::class.java.simpleName
    val fragmentTransaction = this.beginTransaction()
    fragmentTransaction.apply {
        setCustomAnimations(R.anim.slide_in_right, 0)
        add(container, fragment, tag)
        addToBackStack(tag)
        commitAllowingStateLoss()
    }
}

@SuppressLint("ResourceType", "CommitTransaction")
fun FragmentManager.replaceFragment(fragment: Fragment, container: Int) {
    val tag = fragment::class.java.simpleName
    val fragmentTransaction = this.beginTransaction()
    fragmentTransaction.apply {
        setCustomAnimations(R.anim.slide_in_down, 0)
        replace(container, fragment, tag)
        addToBackStack(tag)
        commit()
    }
}

@SuppressLint("ResourceType", "CommitTransaction")
fun FragmentManager.replaceFragmentWithSharedTransition(fragment: Fragment, container: Int, viewBackdrop: View, viewPoster: View) {
    val tag = fragment::class.java.simpleName
    val fragmentTransaction = this.beginTransaction()
    fragmentTransaction.apply {
        addSharedElement(viewBackdrop,  ViewCompat.getTransitionName(viewBackdrop))
        addSharedElement(viewPoster,  ViewCompat.getTransitionName(viewPoster))
        addToBackStack(tag)
        replace(container, fragment, tag)
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