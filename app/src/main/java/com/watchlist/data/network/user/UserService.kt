package com.watchlist.data.network.user

import com.watchlist.data.entity.UserEntity
import com.watchlist.domain.params.UserLoginParams
import com.watchlist.domain.params.UserSignUpParams
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