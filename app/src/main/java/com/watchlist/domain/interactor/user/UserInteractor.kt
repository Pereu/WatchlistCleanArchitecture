package com.watchlist.domain.interactor.user

import com.watchlist.domain.executor.PostExecutionThread
import com.watchlist.domain.executor.ThreadExecutor
import com.watchlist.domain.model.User
import com.watchlist.domain.model_params.UserLoginParams
import com.watchlist.domain.model_params.UserSignUpParams
import com.watchlist.domain.repository.user.UserRepository
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