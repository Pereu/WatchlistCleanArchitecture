package com.watchlist.presentation.ui.registration.signup

import com.watchlist.domain.interactor.user.UserInteractor
import com.watchlist.domain.model.User
import com.watchlist.domain.model_params.UserSignUpParams
import com.watchlist.presentation.ui.global.BasePresenter
import com.watchlist.presentation.ui.registration.login.view.LoginView
import rx.lang.kotlin.FunctionSubscriber
import javax.inject.Inject

/**
 * Created by alexanderpereu on 30.01.2018.
 */

class SignUpPresenter  <V : LoginView>
@Inject constructor(private val userInteractor: UserInteractor) : BasePresenter<V>()  {

    private var isEmail = false
    private var isPassword = false
    private var isName = false

     override fun viewIsReady() {
         getView()?.blockButton()
    }

    fun isValid(): Boolean  = isEmail && isPassword && isName

    fun validEmail(mail: String) {
        if (mail.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            isEmail = false
            getView()?.emailError()
        } else {
            isEmail= true
            getView()?.emailSuccess()
        }
    }

    fun validPassword(password: String) {
        if (password.length < 6) {
            isPassword = false
            getView()?.passwordError()
        } else {
            isPassword = true
            getView()?.passwordSuccess()
        }
    }

    fun validName(name: String) {
        if (name.length < 3) {
            isName = false
            getView()?.nameError()
        } else {
            isName = true
            getView()?.nameSuccess()
        }
    }

    fun signUp(mail: String, password: String, name: String, checkInternet: Boolean) {
        if (checkInternet) {
            getView()?.showLoading()
            val user = UserSignUpParams()
            user.email = mail
            user.password = password
            user.UserName = name
            userInteractor.userSignUpParams = user
            userInteractor.executeSignUp(FunctionSubscriber<User>()
                    .onNext { getView()?.showSuccess(it) }
                    .onError { getView()?.showError(it) })
        } else {
            getView()?.showMessage("No internet")
        }
    }

    override fun viewIsGone() {
        userInteractor.unsubscribe()
    }
}