package com.watchlist.presentation.ui.fragments

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.pawegio.kandroid.longToast
import com.watchlist.R
import com.watchlist.domain.model.User
import com.watchlist.presentation.extension.block
import com.watchlist.presentation.extension.onTextChanged
import com.watchlist.presentation.ui.activity.MainActivity
import com.watchlist.presentation.ui.global.BaseFragment
import com.watchlist.presentation.ui.mvp.presenters.LoginPresenter
import com.watchlist.presentation.ui.mvp.views.LoginView
import kotlinx.android.synthetic.main.fragment_login.*
import org.jetbrains.anko.indeterminateProgressDialog
import javax.inject.Inject


/**
 * Created by alexanderpereu on 22.01.2018.
 */
class LoginFragment : BaseFragment(), LoginView {

    @Inject
    @InjectPresenter
    lateinit var presenter: LoginPresenter

    @ProvidePresenter
    fun provideLoginPresenter(): LoginPresenter {
        return presenter
    }

    private var progressDialog: ProgressDialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.viewIsReady()
        fragment_login_user_email_input.onTextChanged { presenter.validEmail(it)}
        fragment_login_user_password_input.onTextChanged { presenter.validPassword(it)}
        fragment_login_btn.setOnClickListener { presenter.login(fragment_login_user_email_input.text.toString(), fragment_login_user_password_input.text.toString(), checkInternet() ) }
        fragment_login_reg_btn.setOnClickListener { presenter.showCreateAccount(activity as AppCompatActivity, R.id.activity_login_container) }
    }

    override fun showMessage(message: String) {
        longToast(message)
    }
    override fun showLoading() {
        progressDialog = indeterminateProgressDialog(resources.getString(R.string.please_wait))
    }
    override fun blockButton() {
        fragment_login_btn.block(presenter.isValid(), R.color.colorPrimaryDark, R.color.colorDisabled)  }

    override fun emailError() {
        fragment_login_user_email.error = resources.getString(R.string.valid_email)
        blockButton()
    }

    override fun passwordError() {
        fragment_login_user_password.error = resources.getString(R.string.valid_password)
        blockButton()
    }

    override fun emailSuccess() {
        fragment_login_user_email.isErrorEnabled = false
        blockButton()
    }

    override fun passwordSuccess() {
        fragment_login_user_password.isErrorEnabled = false
        blockButton()
    }

    override fun showSuccess(it: User) {
        progressDialog?.dismiss()
        presenter.showOnBoarding(activity as AppCompatActivity, R.id.activity_login_container)
    }

    override fun showError(it: Throwable) {
        progressDialog?.dismiss()
        it.message?.let { it1 -> longToast(it1) }
    }

    override fun showHome() {
        startActivity(Intent(activity, MainActivity::class.java))
        activity.finish()
    }
    override fun nameError() {}

    override fun nameSuccess() {}
}
