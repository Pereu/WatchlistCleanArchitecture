package com.watchlist.data.repository.user_datasourse

import com.watchlist.data.db.DBHelper
import com.watchlist.data.entity.UserEntity
import com.watchlist.data.network.user.UserRestApi
import com.watchlist.domain.model_params.UserLoginParams
import com.watchlist.domain.model_params.UserSignUpParams
import rx.Observable

/**
 * Created by alexanderpereu on 25.01.2018.
 */
class UserCloudDataStore (private val restApi: UserRestApi, private val dbHelper: DBHelper) : UserDataStore {

    override fun userLogin(login: UserLoginParams): Observable<UserEntity> {
        return restApi.user(login).doOnNext {
            dbHelper.saveUserCredential(it)
        }    }

    override fun userSign(sign: UserSignUpParams): Observable<UserEntity> {
        return restApi.user(sign).doOnNext {
            dbHelper.saveUserCredential(it)
        }     }

    override fun isUserAlreadyExist(): Boolean {
        return !dbHelper.getToken().isEmpty()
        }
    }
