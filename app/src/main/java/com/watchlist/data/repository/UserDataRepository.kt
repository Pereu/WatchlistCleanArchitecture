package com.watchlist.data.repository

import com.watchlist.data.entity.mapper.UserMapper
import com.watchlist.data.repository.user_datasourse.UserDataFactory
import com.watchlist.domain.model.User
import com.watchlist.domain.model_params.UserLoginParams
import com.watchlist.domain.model_params.UserSignUpParams
import com.watchlist.domain.repository.user.UserRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by alexanderpereu on 25.01.2018.
 */
class UserDataRepository @Inject constructor(private val mapper: UserMapper, private val dataFactory: UserDataFactory) : UserRepository {

    override fun loginUser(login: UserLoginParams): Observable<User> {
        return dataFactory.createCloudDataStore().userLogin(login).map({ mapper.transform(it) })    }

    override fun signUpUser(sign: UserSignUpParams): Observable<User> {
        return dataFactory.createCloudDataStore().userSign(sign).map({ mapper.transform(it) })    }
}