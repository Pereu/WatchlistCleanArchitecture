package com.android.watchlist.watchlist.domain.repository.user

import com.android.watchlist.watchlist.domain.model.User
import com.android.watchlist.watchlist.domain.model_params.UserLoginParams
import com.android.watchlist.watchlist.domain.model_params.UserSignUpParams
import rx.Observable

/**
 * Created by alexanderpereu on 25.01.2018.
 */
interface UserRepository {

    fun loginUser(login: UserLoginParams): Observable<User>

    fun signUpUser(sign: UserSignUpParams): Observable<User>
}