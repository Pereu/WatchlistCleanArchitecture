package com.watchlist.presentation.di.modules.fragment_module

import com.watchlist.data.db.DBHelper
import com.watchlist.data.entity.mapper.UserMapper
import com.watchlist.data.executor.JobExecutor
import com.watchlist.data.network.user.UserRestApi
import com.watchlist.data.repository.UserDataRepository
import com.watchlist.data.repository.user_datasourse.UserDataFactory
import com.watchlist.domain.interactor.user.UserInteractor
import com.watchlist.presentation.UIThread
import com.watchlist.presentation.ui.mvp.presenters.SignUpPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by alexanderpereu on 06.02.2018.
 */
@Module
class SignUpModule {

    @Provides
    fun provideSignUpPresenter() : SignUpPresenter {
        return SignUpPresenter(UserInteractor(JobExecutor(), UIThread(),
                UserDataRepository(UserMapper(), UserDataFactory(UserRestApi(), DBHelper()))))
    }
}