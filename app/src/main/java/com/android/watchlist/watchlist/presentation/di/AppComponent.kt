package com.android.watchlist.watchlist.presentation.di

import com.android.watchlist.watchlist.WatchListApplication
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