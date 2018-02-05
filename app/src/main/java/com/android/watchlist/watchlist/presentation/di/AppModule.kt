package com.android.watchlist.watchlist.presentation.di

import com.android.watchlist.watchlist.data.executor.JobExecutor
import com.android.watchlist.watchlist.data.repository.UserDataRepository
import com.android.watchlist.watchlist.domain.executor.PostExecutionThread
import com.android.watchlist.watchlist.domain.executor.ThreadExecutor
import com.android.watchlist.watchlist.domain.repository.user.UserRepository
import com.android.watchlist.watchlist.presentation.UIThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by alexanderpereu on 22.01.2018.
 */
 @Module
  class AppModule {

//  @Provides
//  @Singleton
//  fun application(): WatchListApplication {
//    return androidApplication
//  }

//  @Provides
//  @Singleton
//  fun provideAppCompatActivity(activity: AppCompatActivity): AppCompatActivity {
//   return activity
//  }

  @Provides
  @Singleton
  fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
    return jobExecutor
  }

  @Provides
  @Singleton
  fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
    return uiThread
  }


  @Provides
  @Singleton
  fun provideUserRepository(dataRepository: UserDataRepository): UserRepository {
    return dataRepository

  }

}