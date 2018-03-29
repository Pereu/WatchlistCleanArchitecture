package com.watchlist.domain.interactor.movie

import com.watchlist.domain.executor.PostExecutionThread
import com.watchlist.domain.executor.ThreadExecutor
import com.watchlist.domain.model.OnBoardingMovie
import com.watchlist.domain.repository.movie.MovieRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by alexanderpereu on 05.02.2018.
 */
class OnBoardingInteractor
@Inject constructor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread, private val movieRepository: MovieRepository)
    : BaseMovieInteractor<OnBoardingMovie>(threadExecutor, postExecutionThread) {


    var take = 0
    var skip = 0

    override fun buildUseCaseObservableList(): Observable<ArrayList<OnBoardingMovie>> {
        return movieRepository.getOnBoarding(take, skip)
    }
    override fun buildUseCaseObservableObject(): Observable<OnBoardingMovie>? {
       return null
    }
}