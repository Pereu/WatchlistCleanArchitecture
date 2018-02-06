package com.watchlist.data.repository.movie_datasourse

import com.watchlist.data.network.movie.MovieRestApi
import javax.inject.Inject

/**
 * Created by alexanderpereu on 06.02.2018.
 */
class MovieDataFactory @Inject constructor(private val restApi: MovieRestApi) {

    fun createCloudDataStore(): MovieDataStore {
        return MovieCloudDataStore(restApi)
    }
}