package com.android.watchlist.watchlist.presentation.di

import com.android.watchlist.watchlist.data.data_base.DBHelper
import com.android.watchlist.watchlist.data.entity.mapper.UserMapper
import com.android.watchlist.watchlist.data.executor.JobExecutor
import com.android.watchlist.watchlist.data.network.RestApi
import com.android.watchlist.watchlist.data.repository.UserDataRepository
import com.android.watchlist.watchlist.data.repository.datasourse.UserDataFactory
import com.android.watchlist.watchlist.domain.interactor.movie.MovieInteractor
import com.android.watchlist.watchlist.domain.interactor.user.UserInteractor
import com.android.watchlist.watchlist.presentation.UIThread
import com.android.watchlist.watchlist.presentation.ui.mvp.presenters.LoginPresenter
import com.android.watchlist.watchlist.presentation.ui.mvp.presenters.OnBoardingPresenter
import com.android.watchlist.watchlist.presentation.ui.mvp.presenters.SignUpPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by alexanderpereu on 22.01.2018.
 */

@Module
class FragmentModule {

    @Provides
    fun provideLoginPresenter() : LoginPresenter {
        return LoginPresenter(UserInteractor(JobExecutor(), UIThread(),
                UserDataRepository(UserMapper(), UserDataFactory(RestApi(), DBHelper()))))
    }

    @Provides
    fun provideSignUpPresenter() : SignUpPresenter {
        return SignUpPresenter(UserInteractor(JobExecutor(), UIThread(),
                UserDataRepository(UserMapper(), UserDataFactory(RestApi(), DBHelper()))))
    }

//    @Provides
//    fun provideOnBoardingPresenter() : OnBoardingPresenter {
//        return OnBoardingPresenter(MovieInteractor(JobExecutor(), UIThread(),
//                UserDataRepository(UserMapper(), UserDataFactory(RestApi(), DBHelper()))))
//    }

}