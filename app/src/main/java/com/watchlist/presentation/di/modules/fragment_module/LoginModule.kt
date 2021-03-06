package com.watchlist.presentation.di.modules.fragment_module

import com.watchlist.data.db.DBHelper
import com.watchlist.data.entity.mapper.UserMapper
import com.watchlist.data.executor.JobExecutor
import com.watchlist.data.network.user.UserRestApi
import com.watchlist.data.repository.UserDataRepository
import com.watchlist.data.repository.user_datasourse.UserDataFactory
import com.watchlist.domain.interactor.user.UserInteractor
import com.watchlist.presentation.UIThread
import com.watchlist.presentation.ui.registration.login.LoginPresenter
import com.watchlist.presentation.ui.registration.login.view.LoginView
import dagger.Module
import dagger.Provides

/**
 * Created by alexanderpereu on 06.02.2018.
 */
@Module
class LoginModule {

    @Provides
    fun provideLoginPresenter() : LoginPresenter<LoginView> {
        return LoginPresenter(UserInteractor(JobExecutor(), UIThread(),
                UserDataRepository(UserMapper(), UserDataFactory(UserRestApi(), DBHelper()))))
    }
}