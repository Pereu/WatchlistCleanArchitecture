package com.watchlist.data.network.movie

import com.watchlist.data.entity.OnBoardingEntity
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import rx.Observable

/**
 * Created by alexanderpereu on 06.02.2018.
 */
interface MovieService {

    @GET("Movies/GetOnboarding/Get")
    fun getOnBoardingMovie(@Header("X-Token") token: String,
                                    @Query("take") take: Int,
                                    @Query("skip") skip: Int): Observable<ArrayList<OnBoardingEntity>>
}