package com.watchlist.presentation.ui.registration.login.view

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pawegio.kandroid.longToast
import com.watchlist.R
import com.watchlist.domain.model.User
import com.watchlist.presentation.extension.addFragment
import com.watchlist.presentation.extension.block
import com.watchlist.presentation.extension.onTextChanged
import com.watchlist.presentation.extension.replaceFragment
import com.watchlist.presentation.ui.bottom_tabs.MainActivity
import com.watchlist.presentation.ui.global.view.BaseFragment
import com.watchlist.presentation.ui.registration.login.LoginPresenter
import com.watchlist.presentation.ui.registration.onboarding.view.OnBoardingFragment
import com.watchlist.presentation.ui.registration.signup.view.SignUpFragment
import kotlinx.android.synthetic.main.fragment_login.*
import org.jetbrains.anko.indeterminateProgressDialog
import javax.inject.Inject

/**
 * Created by alexanderpereu on 22.01.2018.
 */
class LoginFragment : BaseFragment(), LoginView {

    @Inject
    lateinit var presenter: LoginPresenter<LoginView>

    private var progressDialog: ProgressDialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        fragment_login_user_email_input.onTextChanged { presenter.validEmail(it)}
        fragment_login_user_password_input.onTextChanged { presenter.validPassword(it)}
        fragment_login_btn.setOnClickListener { presenter.login(fragment_login_user_email_input.text.toString(), fragment_login_user_password_input.text.toString(), checkInternet() ) }
        fragment_login_reg_btn.setOnClickListener { fragmentManager.addFragment(SignUpFragment(), R.id.activity_login_container) }
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
        fragmentManager.replaceFragment(OnBoardingFragment(), R.id.activity_login_container)
    }

    override fun showError(error: Throwable) {
        progressDialog?.dismiss()
        error.message?.let { it -> longToast(it) }
    }

    override fun showHome() {
        startActivity(Intent(activity, MainActivity::class.java))
        activity.finish()
    }
    override fun nameError() {}

    override fun nameSuccess() {}

    override fun showLoading(isLoading: Boolean) {}
}
