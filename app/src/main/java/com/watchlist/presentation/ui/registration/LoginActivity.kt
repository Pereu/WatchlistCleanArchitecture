package com.watchlist.presentation.ui.registration

import android.os.Bundle
import com.watchlist.R
import com.watchlist.presentation.extension.addFragment
import com.watchlist.presentation.extension.backPressed
import com.watchlist.presentation.ui.registration.login.view.LoginFragment
import com.watchlist.presentation.ui.global.view.BaseActivity

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