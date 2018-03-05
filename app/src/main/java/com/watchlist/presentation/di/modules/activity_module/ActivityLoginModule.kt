package com.watchlist.presentation.di.modules.activity_module

import com.watchlist.presentation.di.modules.fragment_module.*
import com.watchlist.presentation.di.scopes.FragmentScope
import com.watchlist.presentation.ui.fragments.HomeTabFragment
import com.watchlist.presentation.ui.fragments.LoginFragment
import com.watchlist.presentation.ui.fragments.OnBoardingFragment
import com.watchlist.presentation.ui.fragments.SignUpFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by alexanderpereu on 22.01.2018.
 */
@Module
abstract class ActivityLoginModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [(FragmentModule::class), (LoginModule::class)])
    abstract fun bindLoginFragment(): LoginFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(FragmentModule::class), (SignUpModule::class)])
    abstract fun bindSignUpFragment(): SignUpFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(FragmentModule::class), (OnBoardingModule::class)])
    abstract fun bindOnBoardingFragment(): OnBoardingFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(FragmentModule::class), (HomeModule::class)])
    abstract fun bindHomeTabFragment(): HomeTabFragment


}