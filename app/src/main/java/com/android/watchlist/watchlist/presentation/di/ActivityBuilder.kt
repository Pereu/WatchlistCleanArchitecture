package com.android.watchlist.watchlist.presentation.di

import com.android.watchlist.watchlist.presentation.ui.activity.LoginActivity
import com.android.watchlist.watchlist.presentation.ui.fragments.LoginFragment
import com.android.watchlist.watchlist.presentation.ui.fragments.SignUpFragment
import com.android.watchlist.watchlist.presentation.ui.mvp.presenters.RegistrationPresenter
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by alexanderpereu on 22.01.2018.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(ActivityModule::class)])
    abstract fun bindLoginActivity (): LoginActivity

    @ContributesAndroidInjector(modules = [(FragmentModule::class)])
    abstract fun bindLoginFragment(): LoginFragment

    @ContributesAndroidInjector(modules = [(FragmentModule::class)])
    abstract fun bindSignUpFragment(): SignUpFragment

}