package com.watchlist.data.repository.movie_datasourse

import com.watchlist.data.db.DBHelper
import com.watchlist.data.network.movie.MovieRestApi
import com.watchlist.domain.model.InCinemaMovie
import com.watchlist.domain.model.OnBoardingMovie
import retrofit2.Call

/**
 * Created by alexanderpereu on 06.02.2018.
 */
class MovieCloudDataStore (private val restApi: MovieRestApi, val dbHelper: DBHelper) : MovieDataStore{

    override fun getInCinemaMovies(take: Int, skip: Int, todayDate: String): Call<InCinemaMovie> {
        return restApi.getInCinemaMovies(dbHelper.getToken(), take, skip, todayDate)
    }

    override fun getNewOnBoarding(take: Int, skip: Int): Call<ArrayList<OnBoardingMovie>> {
        return restApi.getNewOnBoarding(dbHelper.getToken(), take, skip)
    }
}