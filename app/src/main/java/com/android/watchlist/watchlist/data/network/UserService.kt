package com.android.watchlist.watchlist.data.network

import com.android.watchlist.watchlist.data.entity.UserEntity
import com.android.watchlist.watchlist.domain.model_params.UserLoginParams
import com.android.watchlist.watchlist.domain.model_params.UserSignUpParams
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * Created by alexanderpereu on 25.01.2018.
 */
interface UserService {
    @POST("Account/Login")
    fun loginUser(@Body loginUser: UserLoginParams): Observable<UserEntity>

    @POST("Account/Create")
    fun signUpUser(@Body sign: UserSignUpParams): Observable<UserEntity>

}