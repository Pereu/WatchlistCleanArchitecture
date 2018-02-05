package com.android.watchlist.watchlist.presentation.ui.activity

import android.os.Bundle
import com.android.watchlist.R
import com.android.watchlist.watchlist.presentation.ui.global.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
