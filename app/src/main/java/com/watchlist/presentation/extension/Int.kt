package com.watchlist.presentation.extension

fun Int.getCurrentItem (length: Int) : Int {
    return if (length > 5 ) {
        length - 2
    } else {
        0
    }

}