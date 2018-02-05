package com.android.watchlist.watchlist.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.watchlist.R
import com.android.watchlist.watchlist.domain.model.OnBoardingMovie
import com.android.watchlist.watchlist.presentation.ui.adapters.holders.OnBoardingMovieHolder

/**
 * Created by alexanderpereu on 05.02.2018.
 */
class OnBoardingAdapter : BaseAdapter<OnBoardingMovie, OnBoardingMovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): OnBoardingMovieHolder {
        return OnBoardingMovieHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_on_boarding, parent, false))
    }
}