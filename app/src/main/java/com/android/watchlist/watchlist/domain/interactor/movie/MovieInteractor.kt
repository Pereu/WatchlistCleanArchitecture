package com.android.watchlist.watchlist.domain.interactor.movie

import com.android.watchlist.watchlist.domain.executor.PostExecutionThread
import com.android.watchlist.watchlist.domain.executor.ThreadExecutor
import com.android.watchlist.watchlist.domain.interactor.user.BaseUserInteractor
import com.android.watchlist.watchlist.domain.model.OnBoardingMovie
import com.android.watchlist.watchlist.domain.repository.movie.MovieRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by alexanderpereu on 05.02.2018.
 */
class MovieInteractor  @Inject constructor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread,
                                           private val movieRepository: MovieRepository) : BaseMovieInteractor<OnBoardingMovie>(threadExecutor, postExecutionThread) {


    override fun buildUseCaseObservableOnBoarding(): Observable<ArrayList<OnBoardingMovie>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}