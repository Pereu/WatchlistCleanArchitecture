package com.watchlist.presentation.ui.settings

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.watchlist.R
import com.watchlist.presentation.extension.addFragment

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        supportFragmentManager.addFragment(SettingsFragment(), R.id.activity_settings_container)
    }

    override fun onBackPressed() {
        finish()
    }
}