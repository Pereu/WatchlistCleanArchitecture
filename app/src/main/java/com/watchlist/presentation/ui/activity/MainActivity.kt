package com.watchlist.presentation.ui.activity

import android.os.Bundle
import com.watchlist.R
import com.watchlist.presentation.ui.global.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
