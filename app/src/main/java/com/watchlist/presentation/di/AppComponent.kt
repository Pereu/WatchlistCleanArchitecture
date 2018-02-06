package com.watchlist.presentation.di

import com.watchlist.WatchListApplication
import com.watchlist.presentation.di.modules.ActivityBuilder
import com.watchlist.presentation.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

/**
 * Created by alexanderpereu on 22.01.2018.
 */
@Component(modules = (arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class
)))
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application:WatchListApplication): Builder
        fun build(): AppComponent
    }
    fun inject (app:WatchListApplication)
}