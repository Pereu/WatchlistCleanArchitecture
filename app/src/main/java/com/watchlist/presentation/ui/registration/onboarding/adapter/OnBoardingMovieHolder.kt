package com.watchlist.presentation.ui.registration.onboarding.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.watchlist.R
import com.watchlist.domain.model.OnBoardingMovie
import com.watchlist.presentation.ui.global.adapter.BaseViewHolder
import kotlinx.android.synthetic.main.item_on_boarding.view.*

/**
 * Created by alexanderpereu on 02.02.2018.
 */
class OnBoardingMovieHolder (private val view: View) : BaseViewHolder<OnBoardingMovie>(view) {

    override fun onBind(item: OnBoardingMovie) {
        Glide.with(view.context)
                .load(item.Posters?.get(0)?.Url)
                .apply(RequestOptions().placeholder(R.drawable.empty_poster).diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                .into(view.item_on_boarding_poster)
    }
}