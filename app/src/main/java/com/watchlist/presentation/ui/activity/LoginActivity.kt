package com.watchlist.presentation.ui.activity

import android.os.Bundle
import com.watchlist.R
import com.watchlist.presentation.ui.global.BaseActivity
import com.watchlist.presentation.ui.mvp.presenters.RegistrationPresenter
import com.watchlist.presentation.ui.mvp.views.RegistrationView
import com.arellomobile.mvp.presenter.InjectPresenter

/**
 * Created by alexanderpereu on 22.01.2018.
 */
class LoginActivity : BaseActivity(), RegistrationView {

    @InjectPresenter
    lateinit var presenter: RegistrationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.viewIsReady(this, R.id.activity_login_container)
    }

    override fun onBackPressed() {
        presenter.back(this)
    }
}