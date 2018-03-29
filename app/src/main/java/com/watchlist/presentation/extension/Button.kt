package com.watchlist.presentation.extension

import android.widget.Button
import com.watchlist.R

/**
 * Created by alexanderpereu on 23.01.2018.
 */
fun Button.block(value:Boolean){
    isEnabled = value
    //setTextColor(ContextCompat.getColor(context, if(!value) positiveColor else negativeColor))
    //setBackgroundColor(ContextCompat.getColor(context, if (!value) negativeColor else positiveColor))
    setBackgroundResource(if (!value) R.drawable.round_btn_login else R.drawable.round_btn_sign_up )
}