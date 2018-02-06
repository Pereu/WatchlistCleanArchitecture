package com.watchlist.presentation.extension

import android.support.v4.content.ContextCompat
import android.widget.Button

/**
 * Created by alexanderpereu on 23.01.2018.
 */
fun Button.block(value:Boolean, positiveColor:Int, negativeColor:Int){
    isEnabled = value
    setTextColor(ContextCompat.getColor(context, if(!value) positiveColor else negativeColor))
    setBackgroundColor(ContextCompat.getColor(context, if (!value) negativeColor else positiveColor))
}