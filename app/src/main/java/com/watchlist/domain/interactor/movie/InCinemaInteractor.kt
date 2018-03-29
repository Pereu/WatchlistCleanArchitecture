package com.watchlist.domain.interactor.movie

import com.watchlist.domain.executor.PostExecutionThread
import com.watchlist.domain.executor.ThreadExecutor
import com.watchlist.domain.model.InCinemaMovie
import com.watchlist.domain.repository.movie.MovieRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by alexandr on 26/03/2018.
 */
class InCinemaInteractor
@Inject constructor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread, private val movieRepository: MovieRepository)
    : BaseMovieInteractor<InCinemaMovie>(threadExecutor, postExecutionThread) {


    var take = 0
    var skip = 0
    var date = ""


    override fun buildUseCaseObservableObject(): Observable<InCinemaMovie> {
        return  movieRepository.getInCinemaMovies(take, skip)
    }
    override fun buildUseCaseObservableList(): Observable<ArrayList<InCinemaMovie>>? {
        return null
    }
}
