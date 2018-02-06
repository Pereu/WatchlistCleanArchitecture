package com.watchlist.data.repository.movie_datasourse

import com.watchlist.data.entity.OnBoardingEntity
import rx.Observable

/**
 * Created by alexanderpereu on 06.02.2018.
 */
interface MovieDataStore {

    fun getOnBoarding (take: Int, skip: Int): Observable<ArrayList<OnBoardingEntity>>
}