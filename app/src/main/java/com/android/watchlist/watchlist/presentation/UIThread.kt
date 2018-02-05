package com.android.watchlist.watchlist.presentation

import com.android.watchlist.watchlist.domain.executor.PostExecutionThread
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by alexanderpereu on 29.01.2018.
 */
@Singleton
class UIThread
@Inject constructor() : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}