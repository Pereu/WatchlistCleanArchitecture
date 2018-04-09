package com.watchlist.data.network.movie

import com.watchlist.domain.model.InCinemaMovie
import com.watchlist.domain.model.OnBoardingMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Created by alexanderpereu on 06.02.2018.
 */
interface MovieService {

    @GET("SearchMovie/Search/Get")
    fun getInCinemaMovies(@Header("X-Token") token: String,
                          @Header("CityApp") city: String,
                          @Query("take") take: Int,
                          @Query("skip") skip: Int,
                          @Query("KeyWords")  tags : String,
                          @Query("SearchDate")  searchDate : String,
                          @Query("IsSingleChoice") isSingleChoice : Boolean) : Call<InCinemaMovie>

    @GET("Movies/GetOnboarding/Get")
    fun getNewOnBoardingMovie(@Header("X-Token") token: String,
                           @Query("take") take: Int,
                           @Query("skip") skip: Int): Call<ArrayList<OnBoardingMovie>>

}