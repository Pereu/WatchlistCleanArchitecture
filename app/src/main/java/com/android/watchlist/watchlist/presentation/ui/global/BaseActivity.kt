package com.android.watchlist.watchlist.presentation.ui.global

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.arellomobile.mvp.MvpAppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector

import javax.inject.Inject

/**
 * Created by alexanderpereu on 22.01.2018.
 */
abstract class BaseActivity : MvpAppCompatActivity(), HasFragmentInjector, BaseView {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun fragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun context(): Context = this

    override fun activity(): AppCompatActivity = this
}