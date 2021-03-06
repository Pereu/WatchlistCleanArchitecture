package com.watchlist.presentation.di.modules.fragment_module

import com.watchlist.data.db.DBHelper
import com.watchlist.data.network.movie.MovieRestApi
import com.watchlist.data.repository.MovieDataRepository
import com.watchlist.data.repository.movie_datasourse.MovieDataFactory
import com.watchlist.domain.interactor.movie.OnBoardingInteractor
import com.watchlist.presentation.ui.registration.onboarding.OnBoardingPresenter
import com.watchlist.presentation.ui.registration.onboarding.view.OnBoardingView
import dagger.Module
import dagger.Provides

/**
 * Created by alexanderpereu on 06.02.2018.
 */
@Module
class OnBoardingModule {

    @Provides
    fun provideOnBoardingPresenter() : OnBoardingPresenter<OnBoardingView> {
        return OnBoardingPresenter(OnBoardingInteractor(MovieDataRepository(MovieDataFactory(MovieRestApi(), DBHelper()))))
    }
}