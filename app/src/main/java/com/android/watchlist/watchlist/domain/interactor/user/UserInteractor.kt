package com.android.watchlist.watchlist.domain.interactor.user

import com.android.watchlist.watchlist.domain.executor.PostExecutionThread
import com.android.watchlist.watchlist.domain.executor.ThreadExecutor
import com.android.watchlist.watchlist.domain.model.User
import com.android.watchlist.watchlist.domain.model_params.UserLoginParams
import com.android.watchlist.watchlist.domain.model_params.UserSignUpParams
import com.android.watchlist.watchlist.domain.repository.user.UserRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by alexanderpereu on 24.01.2018.
 */
class UserInteractor @Inject constructor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread,
                                         private val userRepository: UserRepository) : BaseUserInteractor<User>(threadExecutor, postExecutionThread) {

    var userLoginParams = UserLoginParams()

    var userSignUpParams = UserSignUpParams()

    override fun buildUseCaseObservable(): Observable<User> {
        return this.userRepository.loginUser(userLoginParams)
    }

    override fun buildUseCaseObservableSign(): Observable<User> {
        return this.userRepository.signUpUser(userSignUpParams)    }
}