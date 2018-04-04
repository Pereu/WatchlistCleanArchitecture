package com.watchlist.data.repository.movie_datasourse

import com.watchlist.domain.model.InCinemaMovie
import com.watchlist.domain.model.OnBoardingMovie
import retrofit2.Call
import rx.Observable

/**
 * Created by alexanderpereu on 06.02.2018.
 */
interface MovieDataStore  {

    fun getInCinemaMovies(take: Int, skip: Int): Observable<InCinemaMovie>
    fun getNewOnBoarding(take: Int, skip: Int): Call<ArrayList<OnBoardingMovie>>
}