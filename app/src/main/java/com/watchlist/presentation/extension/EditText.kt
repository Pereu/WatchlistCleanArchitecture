package com.watchlist.presentation.extension

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * Created by alexanderpereu on 23.01.2018.
 */
fun EditText.onTextChanged(callback: (String)->Unit){
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable) {
            callback.invoke(s.toString())
        }
    })
}