package com.watchlist.presentation.ui.adapters.holders

import android.view.View
import com.bumptech.glide.Glide
import com.watchlist.domain.model.OnBoardingMovie
import kotlinx.android.synthetic.main.item_on_boarding.view.*

/**
 * Created by alexanderpereu on 02.02.2018.
 */
class OnBoardingMovieHolder (private val view: View) : BaseViewHolder<OnBoardingMovie>(view) {

    override fun onBind(item: OnBoardingMovie) {
        Glide.with(view.context)
                .load(item.Posters?.get(0)?.Url)
                .into(view.item_on_boarding_poster)
    }
}