package com.android.watchlist.watchlist.presentation.ui.adapters.holders

import android.view.View
import com.android.watchlist.watchlist.domain.model.OnBoardingMovie

/**
 * Created by alexanderpereu on 02.02.2018.
 */
class OnBoardingMovieHolder (view: View) : BaseViewHolder<OnBoardingMovie>(view) {

    override fun onBind(item: OnBoardingMovie) {
        itemView.context
    }
}