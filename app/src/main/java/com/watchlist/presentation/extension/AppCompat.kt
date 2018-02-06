package com.watchlist.presentation.extension

import android.app.Fragment
import android.app.FragmentManager
import android.support.v7.app.AppCompatActivity

/**
 * Created by alexanderpereu on 22.01.2018.
 */

fun AppCompatActivity.addFragment(fragment: Fragment, container: Int){
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction?.add(container, fragment)
    fragmentTransaction.addToBackStack(null)
    fragmentTransaction?.commit()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, container: Int){
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction?.replace(container, fragment)
    fragmentTransaction?.commit()
}

fun AppCompatActivity.removeFragment(fragment: Fragment) {
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction?.remove(fragment)
    fragmentTransaction?.commit()
    fragmentManager.popBackStack()
}

fun AppCompatActivity.clearAllBackStack() {
    (0 until fragmentManager.backStackEntryCount)
            .map { fragmentManager.getBackStackEntryAt(it).id }
            .forEach { fragmentManager.popBackStack(it, FragmentManager.POP_BACK_STACK_INCLUSIVE) }
}

fun AppCompatActivity.backPressed() {
    if (fragmentManager.backStackEntryCount > 1) {
        fragmentManager.popBackStack()
    } else {
        finish()
    }
}