package com.watchlist.presentation.ui.fragments

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.pawegio.kandroid.longToast
import com.watchlist.R
import com.watchlist.domain.model.User
import com.watchlist.presentation.extension.*
import com.watchlist.presentation.ui.activity.MainActivity
import com.watchlist.presentation.ui.global.BaseFragment
import com.watchlist.presentation.ui.mvp.presenters.SignUpPresenter
import com.watchlist.presentation.ui.mvp.views.LoginView
import kotlinx.android.synthetic.main.fragment_sign_in.*
import org.jetbrains.anko.indeterminateProgressDialog
import javax.inject.Inject

/**
 * Created by alexanderpereu on 30.01.2018.
 */
class SignUpFragment : BaseFragment(), LoginView {


    @Inject
    @InjectPresenter
    lateinit var presenter: SignUpPresenter

    @ProvidePresenter
    fun provideSignUpPresenter(): SignUpPresenter {
        return presenter
    }

    private var progressDialog: ProgressDialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_sign_in, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.viewIsReady()
        fragment_sign_up_user_email_input.onTextChanged { presenter.validEmail(it)}
        fragment_sign_up_user_password_input.onTextChanged { presenter.validPassword(it)}
        fragment_sign_up_user_name_input.onTextChanged { presenter.validName(it)}
        fragment_sign_up_btn.setOnClickListener { presenter.signUp(fragment_sign_up_user_email_input.text.toString(),
                fragment_sign_up_user_password_input.text.toString(), fragment_sign_up_user_name_input.text.toString(), checkInternet() ) }
        main_app_bar_arrow.setOnClickListener { fragmentManager.removeFragment( this) }

    }

    override fun showMessage(message: String) {
        longToast(message)
    }

    override fun showLoading() {
        progressDialog = indeterminateProgressDialog(resources.getString(R.string.please_wait))
    }
    override fun blockButton() {
        fragment_sign_up_btn.block(presenter.isValid(), R.color.colorPrimaryDark, R.color.colorDisabled)
    }

    override fun emailError() {
        fragment_sign_up_user_email.error = resources.getString(R.string.valid_email)
        blockButton()    }

    override fun passwordError() {
        fragment_sign_up_user_password.error = resources.getString(R.string.valid_password)
        blockButton()
    }

    override fun emailSuccess() {
        fragment_sign_up_user_email.isErrorEnabled = false
        blockButton()    }

    override fun passwordSuccess() {
        fragment_sign_up_user_password.isErrorEnabled = false
        blockButton()
    }

    override fun nameError() {
        fragment_sign_up_user_name.error = resources.getString(R.string.valid_name)
        blockButton()      }

    override fun nameSuccess() {
        fragment_sign_up_user_name.isErrorEnabled = false
        blockButton()
    }

    override fun showSuccess(it: User) {
        progressDialog?.dismiss()
        fragmentManager.clearAllBackStack()
        fragmentManager.addFragment(OnBoardingFragment(), R.id.activity_login_container)
    }

    override fun showError(it: Throwable) {
        progressDialog?.dismiss()
        it.message?.let { it1 -> longToast(it1) }
    }

    override fun showHome() {
        startActivity(Intent(activity, MainActivity::class.java))
        activity.finish()
    }

}
