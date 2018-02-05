package com.android.watchlist.watchlist.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by alexanderpereu on 02.02.2018.
 */
open class OnBoardingMovie {

    open var MovieId: Long = 0

    open var Posters: List<TrendingImage>? = null
}