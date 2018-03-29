package com.watchlist.presentation.di.modules

import com.watchlist.presentation.di.modules.activity_module.ActivityLoginModule
import com.watchlist.presentation.di.modules.activity_module.ActivityMainModule
import com.watchlist.presentation.di.scopes.ActivityScope
import com.watchlist.presentation.ui.registration.LoginActivity
import com.watchlist.presentation.ui.bottom_tabs.MainActivity
import com.watchlist.presentation.ui.global.view.BaseActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by alexanderpereu on 22.01.2018.
 */
@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(ActivityLoginModule::class)])
    abstract fun bindLoginActivity (): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(ActivityMainModule::class)])
    abstract fun bindMainActivity (): MainActivity

}