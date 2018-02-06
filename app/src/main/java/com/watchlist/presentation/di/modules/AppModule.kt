package com.watchlist.presentation.di.modules

import com.watchlist.data.executor.JobExecutor
import com.watchlist.domain.executor.PostExecutionThread
import com.watchlist.domain.executor.ThreadExecutor
import com.watchlist.presentation.UIThread
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

}