package com.watchlist.domain.repository.movie

import com.watchlist.domain.model.OnBoardingMovie
import rx.Observable

/**
 * Created by alexanderpereu on 05.02.2018.
 */
interface MovieRepository {

    fun getOnBoarding(take: Int, skip: Int) : Observable<ArrayList<OnBoardingMovie>>
}