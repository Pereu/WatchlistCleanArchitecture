package com.watchlist.presentation.extension

import android.annotation.SuppressLint
import android.app.Fragment
import android.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.watchlist.R


@SuppressLint("ResourceType")
        /**
 * Created by alexanderpereu on 22.01.2018.
 */

fun AppCompatActivity.addFragment(fragment: Fragment, container: Int){
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, 0)
    fragmentTransaction?.add(container, fragment)
    fragmentTransaction.addToBackStack(null)
    fragmentTransaction?.commit()
}

@SuppressLint("ResourceType")
fun AppCompatActivity.replaceFragment(fragment: Fragment, container: Int){
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.setCustomAnimations(R.anim.slide_in_down, 0)
    fragmentTransaction?.replace(container, fragment)
    fragmentTransaction?.commit()
}

@SuppressLint("ResourceType")
fun AppCompatActivity.removeFragment(fragment: Fragment) {
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.setCustomAnimations(0, R.anim.slide_out_down)
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