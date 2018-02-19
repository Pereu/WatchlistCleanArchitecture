package com.watchlist.presentation.ui.mvp.presenters

import android.support.v7.app.AppCompatActivity
import com.watchlist.domain.interactor.user.UserInteractor
import com.watchlist.domain.model.User
import com.watchlist.domain.model_params.UserLoginParams
import com.watchlist.presentation.routing.Router
import com.watchlist.presentation.ui.fragments.OnBoardingFragment
import com.watchlist.presentation.ui.fragments.SignUpFragment
import com.watchlist.presentation.ui.mvp.views.LoginView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.watchlist.presentation.ui.fragments.LoginFragment
import rx.lang.kotlin.FunctionSubscriber
import javax.inject.Inject

/**
 * Created by alexanderpereu on 23.01.2018.
 */
@InjectViewState
class LoginPresenter @Inject
constructor(private val userInteractor: UserInteractor) : MvpPresenter<LoginView>() {

    private var isEmail = false
    private var isPassword = false

    fun viewIsReady() {
        if (userInteractor.isUserAlreadyExist()) viewState.showHome() else viewState.blockButton()
    }
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

    fun isValid(): Boolean = isEmail && isPassword

    fun login(email: String, password: String, checkInternet: Boolean) {
        if (checkInternet) {
            viewState.showLoading()
            val user = UserLoginParams()
            user.email = email
            user.password = password
            userInteractor.userLoginParams = user
            userInteractor.executeLogin(FunctionSubscriber<User>()
                    .onNext { viewState.showSuccess(it) }
                    .onError { viewState.showError(it) })
        } else {
            viewState.showMessage("No internet")
        }
    }

    fun showOnBoarding(activity: AppCompatActivity, container: Int) {
        val router = Router(activity)
        router.replaceFragment(OnBoardingFragment(), container)
    }

    fun showCreateAccount(activity: AppCompatActivity, container: Int) {
        val router = Router(activity)
        router.addFragment(SignUpFragment(), container) }

}