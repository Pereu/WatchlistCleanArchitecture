package com.android.watchlist.watchlist.data.repository.datasourse

import com.android.watchlist.watchlist.data.entity.UserEntity
import com.android.watchlist.watchlist.domain.model_params.UserLoginParams
import com.android.watchlist.watchlist.domain.model_params.UserSignUpParams
import rx.Observable

/**
 * Created by alexanderpereu on 25.01.2018.
 */
interface UserDataStore {

    fun userLogin (login: UserLoginParams): Observable<UserEntity>

    fun userSign (sign: UserSignUpParams): Observable<UserEntity>
}