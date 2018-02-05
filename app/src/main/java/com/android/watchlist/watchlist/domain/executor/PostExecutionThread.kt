package com.android.watchlist.watchlist.domain.executor

import rx.Scheduler


/**
 * Created by alexanderpereu on 25.01.2018.
 */
interface PostExecutionThread {
    val scheduler: Scheduler
}