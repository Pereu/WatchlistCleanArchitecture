package com.watchlist.data.repository

import com.watchlist.data.entity.mapper.MovieMapper
import com.watchlist.data.repository.movie_datasourse.MovieDataFactory
import com.watchlist.domain.model.InCinemaMovie
import com.watchlist.domain.model.OnBoardingMovie
import com.watchlist.domain.repository.movie.MovieRepository
import retrofit2.Call
import rx.Observable
import javax.inject.Inject

/**
 * Created by alexanderpereu on 06.02.2018.
 */
class MovieDataRepository
@Inject constructor(private val mapper: MovieMapper, private val dataFactory: MovieDataFactory): MovieRepository {

    override fun getInCinemaMovies(take: Int, skip: Int): Observable<InCinemaMovie> {
        return dataFactory.createCloudDataStore().getInCinemaMovies(take, skip)
    }

    override fun getNewOnBoarding(take: Int, skip: Int): Call<ArrayList<OnBoardingMovie>> {
        return  dataFactory.createCloudDataStore().getNewOnBoarding(take, skip)
    }
}