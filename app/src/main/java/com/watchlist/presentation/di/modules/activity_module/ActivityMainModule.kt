package com.watchlist.presentation.di.modules.activity_module

import com.watchlist.presentation.di.modules.fragment_module.FragmentModule
import com.watchlist.presentation.di.modules.fragment_module.HomeModule
import com.watchlist.presentation.di.scopes.FragmentScope
import com.watchlist.presentation.ui.fragments.HomeTabFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by alexandr on 27/03/2018.
 */
@Module
abstract class ActivityMainModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [(FragmentModule::class), (HomeModule::class)])
    abstract fun bindHomeTabFragment(): HomeTabFragment
}