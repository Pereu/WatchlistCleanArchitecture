package com.watchlist.data.repository.movie_datasourse

import com.watchlist.data.db.DBHelper
import com.watchlist.data.entity.OnBoardingEntity
import com.watchlist.data.network.movie.MovieRestApi
import com.watchlist.domain.model.InCinemaMovie
import rx.Observable

/**
 * Created by alexanderpereu on 06.02.2018.
 */
class MovieCloudDataStore (private val restApi: MovieRestApi, val dbHelper: DBHelper) : MovieDataStore{

    override fun getOnBoarding(take: Int, skip: Int): Observable<ArrayList<OnBoardingEntity>> {
        return restApi.getOnBoarding(dbHelper.getToken(), take, skip)
    }

    override fun getInCinemaMovies(take: Int, skip: Int): Observable<InCinemaMovie> {
        return restApi.getInCinemaMovies(dbHelper.getToken(), take, skip)
    }
}