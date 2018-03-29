package com.watchlist.presentation.extension

import android.support.v4.app.Fragment
import android.widget.LinearLayout

fun Fragment.addParams (): LinearLayout.LayoutParams {
    val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
    params.setMargins(8, 0, 8, 0)
    return params
}