package com.watchlist.presentation.extension

import android.view.View

/**
 * Created by alexanderpereu on 06.02.2018.
 */
var View.visible
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value)
            View.VISIBLE
        else
            View.GONE
    }