package com.watchlist.presentation.ui.adapters.holders

import android.support.v7.widget.RecyclerView
import android.view.View


/**
 * Created by alexanderpereu on 05.02.2018.
 */
abstract class BaseViewHolder <T> (view: View): RecyclerView.ViewHolder(view) {

    abstract fun onBind(item: T)

}