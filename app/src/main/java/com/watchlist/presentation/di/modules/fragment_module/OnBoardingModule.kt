package com.watchlist.presentation.di.modules.fragment_module

import com.watchlist.data.db.DBHelper
import com.watchlist.data.entity.mapper.MovieMapper
import com.watchlist.data.executor.JobExecutor
import com.watchlist.data.network.movie.MovieRestApi
import com.watchlist.data.repository.MovieDataRepository
import com.watchlist.data.repository.movie_datasourse.MovieDataFactory
import com.watchlist.domain.interactor.movie.MovieInteractor
import com.watchlist.presentation.UIThread
import com.watchlist.presentation.ui.mvp.presenters.OnBoardingPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by alexanderpereu on 06.02.2018.
 */
@Module
class OnBoardingModule {

    @Provides
    fun provideOnBoardingPresenter() : OnBoardingPresenter {
        return OnBoardingPresenter(MovieInteractor(JobExecutor(), UIThread(),
                MovieDataRepository(MovieMapper(), MovieDataFactory(MovieRestApi(), DBHelper()))))
    }
}