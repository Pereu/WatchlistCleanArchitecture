package com.watchlist.data.repository

import com.watchlist.data.entity.mapper.MovieMapper
import com.watchlist.data.repository.movie_datasourse.MovieDataFactory
import com.watchlist.domain.model.OnBoardingMovie
import com.watchlist.domain.repository.movie.MovieRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by alexanderpereu on 06.02.2018.
 */
class MovieDataRepository @Inject constructor(private val mapper: MovieMapper, private val dataFactory: MovieDataFactory): MovieRepository {

    override fun getOnBoarding(take: Int, skip: Int): Observable<ArrayList<OnBoardingMovie>> {
        return dataFactory.createCloudDataStore().getOnBoarding(take, skip).map({ mapper.transform(it) })
    }
}