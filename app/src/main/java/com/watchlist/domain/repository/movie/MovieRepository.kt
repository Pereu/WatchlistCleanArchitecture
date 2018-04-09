package com.watchlist.domain.repository.movie

import com.watchlist.domain.model.InCinemaMovie
import com.watchlist.domain.model.OnBoardingMovie
import retrofit2.Call

/**
 * Created by alexanderpereu on 05.02.2018.
 */
interface MovieRepository {

    fun getInCinemaMovies(take: Int, skip: Int, todayDate: String): Call<InCinemaMovie>
    fun getNewOnBoarding(take: Int, skip: Int): Call<ArrayList<OnBoardingMovie>>
}