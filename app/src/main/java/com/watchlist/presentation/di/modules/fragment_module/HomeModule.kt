package com.watchlist.presentation.di.modules.fragment_module

import android.annotation.SuppressLint
import com.watchlist.data.db.DBHelper
import com.watchlist.data.network.movie.MovieRestApi
import com.watchlist.data.repository.MovieDataRepository
import com.watchlist.data.repository.movie_datasourse.MovieDataFactory
import com.watchlist.domain.interactor.movie.InCinemaInteractor
import com.watchlist.presentation.ui.bottomTabs.homeTab.HomePresenter
import com.watchlist.presentation.ui.bottomTabs.homeTab.view.HomeView
import dagger.Module
import dagger.Provides
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by alexanderpereu on 02.03.2018.
 */
@Module
class HomeModule {
    @Provides
    fun provideHomePresenter() : HomePresenter<HomeView> {
        return HomePresenter(InCinemaInteractor(MovieDataRepository(MovieDataFactory(MovieRestApi(), DBHelper())), provideTodayDate()))
    }

    @SuppressLint("SimpleDateFormat")
    @Provides
    fun provideTodayDate() : String {
        val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy")
        return simpleDateFormat.format(Date())
    }
}