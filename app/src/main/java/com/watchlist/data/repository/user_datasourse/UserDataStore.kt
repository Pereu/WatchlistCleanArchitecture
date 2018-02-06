package com.watchlist.data.repository.user_datasourse

import com.watchlist.data.entity.UserEntity
import com.watchlist.domain.model_params.UserLoginParams
import com.watchlist.domain.model_params.UserSignUpParams
import rx.Observable

/**
 * Created by alexanderpereu on 25.01.2018.
 */
interface UserDataStore {

    fun userLogin (login: UserLoginParams): Observable<UserEntity>

    fun userSign (sign: UserSignUpParams): Observable<UserEntity>
}