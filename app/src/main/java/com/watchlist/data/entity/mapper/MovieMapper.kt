package com.watchlist.data.entity.mapper

import com.watchlist.data.entity.OnBoardingEntity
import com.watchlist.domain.model.OnBoardingMovie
import javax.inject.Inject

/**
 * Created by alexanderpereu on 06.02.2018.
 */
class MovieMapper @Inject constructor() : EntryEntityMapper<OnBoardingMovie, OnBoardingEntity>() {

    override fun transform(entity: OnBoardingEntity?): OnBoardingMovie? {
        if (entity != null) {
            val onBoarding = OnBoardingMovie()
            with(onBoarding) {
                MovieId = entity.MovieId
                Posters = entity.Posters
            }
            return onBoarding
        }
        return null
    }
}