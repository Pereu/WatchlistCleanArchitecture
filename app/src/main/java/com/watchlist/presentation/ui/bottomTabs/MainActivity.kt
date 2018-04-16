package com.watchlist.presentation.ui.bottomTabs

import android.os.Bundle
import com.watchlist.R
import com.watchlist.presentation.extension.addFragment
import com.watchlist.presentation.extension.backPressed
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.addFragment(TabFragment(), R.id.activity_tabs_container)
    }

    override fun onBackPressed() {
        supportFragmentManager.backPressed(this)
    }
}
