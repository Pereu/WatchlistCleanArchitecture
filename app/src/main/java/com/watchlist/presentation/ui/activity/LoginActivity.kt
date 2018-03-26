package com.watchlist.presentation.ui.activity

import android.os.Bundle
import com.watchlist.R
import com.watchlist.presentation.extension.addFragment
import com.watchlist.presentation.extension.backPressed
import com.watchlist.presentation.ui.fragments.LoginFragment
import com.watchlist.presentation.ui.global.BaseActivity

/**
 * Created by alexanderpereu on 22.01.2018.
 */
class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        fragmentManager.addFragment(LoginFragment(),  R.id.activity_login_container)
    }

    override fun onBackPressed() {
        fragmentManager.backPressed(this)
    }
}