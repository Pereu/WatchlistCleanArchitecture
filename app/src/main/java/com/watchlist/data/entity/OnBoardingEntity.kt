package com.watchlist.data.entity

import com.watchlist.domain.model.PosterImages

/**
 * Created by alexanderpereu on 06.02.2018.
 */
open class OnBoardingEntity {
    open var MovieId: Long = 0

    open var Posters: ArrayList<PosterImages>? = null
}