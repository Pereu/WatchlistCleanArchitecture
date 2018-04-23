package com.watchlist.presentation.ui.registration.onboarding.adapter

import android.graphics.drawable.Drawable
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.watchlist.R
import com.watchlist.domain.model.OnBoardingMovie
import com.watchlist.presentation.ui.global.adapter.BaseViewHolder
import kotlinx.android.synthetic.main.fragment_detail.view.*
import kotlinx.android.synthetic.main.item_on_boarding.view.*

/**
 * Created by alexanderpereu on 02.02.2018.
 */
class OnBoardingMovieHolder (private val view: View) : BaseViewHolder<OnBoardingMovie>(view) {

    override fun onBind(item: OnBoardingMovie) {
        view.item_on_boarding_poster_shimmer.startShimmerAnimation()
        Glide.with(view.context)
                .load(item.Posters?.get(0)?.Url)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {

                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        view.item_on_boarding_poster_shimmer.stopShimmerAnimation()
                        return false
                    }
                })
                .into(view.item_on_boarding_poster)
    }
}