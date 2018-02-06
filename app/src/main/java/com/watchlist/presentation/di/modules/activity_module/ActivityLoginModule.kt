package com.watchlist.presentation.di.modules.activity_module

import com.watchlist.presentation.di.modules.fragment_module.SignUpModule
import com.watchlist.presentation.di.modules.fragment_module.FragmentModule
import com.watchlist.presentation.di.modules.fragment_module.LoginModule
import com.watchlist.presentation.di.modules.fragment_module.OnBoardingModule
import com.watchlist.presentation.di.scopes.FragmentScope
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

}