package com.watchlist.data.repository

import com.watchlist.data.repository.movie_datasourse.MovieDataFactory
import com.watchlist.domain.model.InCinemaMovie
import com.watchlist.domain.model.OnBoardingMovie
import com.watchlist.domain.repository.movie.MovieRepository
import retrofit2.Call
import javax.inject.Inject

/**
 * Created by alexanderpereu on 06.02.2018.
 */
class MovieDataRepository
@Inject constructor(private val dataFactory: MovieDataFactory): MovieRepository {

    override fun getInCinemaMovies(take: Int, skip: Int, todayDate: String): Call<InCinemaMovie> {
        return dataFactory.createCloudDataStore().getInCinemaMovies(take, skip, todayDate)
    }

    override fun getNewOnBoarding(take: Int, skip: Int): Call<ArrayList<OnBoardingMovie>> {
        return  dataFactory.createCloudDataStore().getNewOnBoarding(take, skip)
    }
}