package com.watchlist.data.repository.movie_datasourse

import com.watchlist.data.db.DBHelper
import com.watchlist.data.entity.OnBoardingEntity
import com.watchlist.data.network.movie.MovieRestApi
import rx.Observable

/**
 * Created by alexanderpereu on 06.02.2018.
 */
class MovieCloudDataStore (private val restApi: MovieRestApi, val dbHelper: DBHelper) : MovieDataStore{
    override fun getOnBoarding(take: Int, skip: Int): Observable<ArrayList<OnBoardingEntity>> {
        return restApi.getOnBoarding(dbHelper.getToken(), take, skip)
    }
}