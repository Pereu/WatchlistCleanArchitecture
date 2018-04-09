package com.watchlist.presentation.ui.registration.login

import android.util.Patterns
import com.watchlist.domain.interactor.user.UserInteractor
import com.watchlist.domain.model.User
import com.watchlist.domain.params.UserLoginParams
import com.watchlist.presentation.ui.global.BasePresenter
import com.watchlist.presentation.ui.registration.login.view.LoginView
import rx.lang.kotlin.FunctionSubscriber
import javax.inject.Inject

/**
 * Created by alexanderpereu on 23.01.2018.
 */

class LoginPresenter <V : LoginView>
@Inject constructor(private val userInteractor: UserInteractor) : BasePresenter<V>() {

    private var password = ""
    private var email = ""

    override fun viewIsReady() {
        if (userInteractor.isUserAlreadyExist())
                getView()?.showHome()
            else
                getView()?.blockButton()
    }

    fun validEmail(mail: String) {
        this.email = mail
        isValidEmail(mail).let {
            if(!it)
                getView()?.emailError()
             else
                getView()?.emailSuccess()

        }
    }

    fun validPassword(password: String) {
        this.password = password
        if (password.length < 6)
            getView()?.passwordError()
        else
            getView()?.passwordSuccess()

    }

    fun isValid(): Boolean = isValidEmail(email) && password.length > 6

    private fun isValidEmail(mail: String)
            = Patterns.EMAIL_ADDRESS.matcher(mail).matches()

    fun login(email: String, password: String, checkInternet: Boolean) {
        if (checkInternet) {
            getView()?.showLoading()
            val user = UserLoginParams()
            user.email = email
            user.password = password
            userInteractor.userLoginParams = user
            userInteractor.executeLogin(FunctionSubscriber<User>()
                    .onNext { getView()?.showSuccess(it) }
                    .onError { it.message?.let { it1 -> getView()?.showError(it1) } })
        } else {
            getView()?.showMessage("No internet")
        }
    }

    override fun viewIsGone() {
        userInteractor.unsubscribe()
    }
}