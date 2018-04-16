package com.watchlist.presentation.extension

import android.annotation.SuppressLint
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
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
        commit()
    }

}

@SuppressLint("ResourceType")
fun FragmentManager.replaceFragment(fragment: Fragment, container: Int){
    val fragmentTransaction = this.beginTransaction()
    fragmentTransaction.setCustomAnimations(R.anim.slide_in_down, 0)
    fragmentTransaction.replace(container, fragment)
    fragmentTransaction.commit()
}

@SuppressLint("ResourceType")
fun FragmentManager.removeFragment(fragment: Fragment) {
    val fragmentTransaction = this.beginTransaction()
    fragmentTransaction.setCustomAnimations(0, R.anim.slide_out_down)
    fragmentTransaction.remove(fragment)
    fragmentTransaction.commit()
    this.popBackStack()
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