package com.watchlist.presentation.ui.mvp.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.watchlist.domain.interactor.user.UserInteractor
import com.watchlist.domain.model.User
import com.watchlist.domain.model_params.UserSignUpParams
import com.watchlist.presentation.ui.mvp.views.LoginView
import rx.lang.kotlin.FunctionSubscriber
import javax.inject.Inject

/**
 * Created by alexanderpereu on 30.01.2018.
 */
@InjectViewState
class SignUpPresenter  @Inject
constructor(private val userInteractor: UserInteractor) : MvpPresenter<LoginView>()  {

    private var isEmail = false
    private var isPassword = false
    private var isName = false

    fun viewIsReady() {
        viewState.blockButton()
    }

    fun isValid(): Boolean  = isEmail && isPassword && isName

    fun validEmail(mail: String) {
        if (mail.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            isEmail = false
            viewState.emailError()
        } else {
            isEmail= true
            viewState.emailSuccess()
        }
    }

    fun validPassword(password: String) {
        if (password.length < 6) {
            isPassword = false
            viewState.passwordError()
        } else {
            isPassword = true
            viewState.passwordSuccess()
        }
    }

    fun validName(name: String) {
        if (name.length < 3) {
            isName = false
            viewState.nameError()
        } else {
            isName = true
            viewState.nameSuccess()
        }
    }

    fun signUp(mail: String, password: String, name: String, checkInternet: Boolean) {
        if (checkInternet) {
            viewState.showLoading()
            val user = UserSignUpParams()
            user.email = mail
            user.password = password
            user.UserName = name
            userInteractor.userSignUpParams = user
            userInteractor.executeSignUp(FunctionSubscriber<User>()
                    .onNext { viewState.showSuccess(it) }
                    .onError { viewState.showError(it) })
        } else {
            viewState.showMessage("No internet")
        }
    }
}