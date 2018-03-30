package com.watchlist.presentation.ui.registration.login

import com.watchlist.domain.interactor.user.UserInteractor
import com.watchlist.domain.model.User
import com.watchlist.domain.model_params.UserLoginParams
import com.watchlist.presentation.ui.global.BasePresenter
import com.watchlist.presentation.ui.registration.login.view.LoginView
import rx.lang.kotlin.FunctionSubscriber
import javax.inject.Inject

/**
 * Created by alexanderpereu on 23.01.2018.
 */

class LoginPresenter <V : LoginView>
@Inject constructor(private val userInteractor: UserInteractor) : BasePresenter<V>() {

    private var isEmail = false
    private var isPassword = false

    override fun viewIsReady() {
        if (userInteractor.isUserAlreadyExist()) getView()?.showHome() else getView()?.blockButton()
    }

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

    fun isValid(): Boolean = isEmail && isPassword

    fun login(email: String, password: String, checkInternet: Boolean) {
        if (checkInternet) {
            getView()?.showLoading()
            val user = UserLoginParams()
            user.email = email
            user.password = password
            userInteractor.userLoginParams = user
            userInteractor.executeLogin(FunctionSubscriber<User>()
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