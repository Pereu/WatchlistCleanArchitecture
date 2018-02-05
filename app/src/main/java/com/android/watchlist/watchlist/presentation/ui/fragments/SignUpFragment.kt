package com.android.watchlist.watchlist.presentation.ui.fragments

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.watchlist.R
import com.android.watchlist.watchlist.domain.model.User
import com.android.watchlist.watchlist.presentation.extension.block
import com.android.watchlist.watchlist.presentation.extension.onTextChanged
import com.android.watchlist.watchlist.presentation.ui.global.BaseFragment
import com.android.watchlist.watchlist.presentation.ui.mvp.presenters.SignUpPresenter
import com.android.watchlist.watchlist.presentation.ui.mvp.views.LoginView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.pawegio.kandroid.longToast
import kotlinx.android.synthetic.main.fragment_sign_in.*
import javax.inject.Inject
import org.jetbrains.anko.indeterminateProgressDialog

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
        fragment_sign_up_btn.setOnClickListener { presenter.signUp(fragment_sign_up_user_email_input.text.toString(), fragment_sign_up_user_password_input.text.toString(), fragment_sign_up_user_name_input.text.toString() ) }
        main_app_bar_arrow.setOnClickListener { presenter.back(activity as AppCompatActivity, this) }

    }

    override fun showLoading() {
        progressDialog = indeterminateProgressDialog("Please wait")
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
        presenter.showOnBoarding(activity as AppCompatActivity, R.id.activity_login_container)    }

    override fun showError(it: Throwable) {
        progressDialog?.dismiss()
        it.message?.let { it1 -> longToast(it1) }
    }

}