package com.android.watchlist.watchlist.data.repository.datasourse

import com.android.watchlist.watchlist.data.data_base.DBHelper
import com.android.watchlist.watchlist.data.entity.UserEntity
import com.android.watchlist.watchlist.data.network.RestApi
import com.android.watchlist.watchlist.domain.model_params.UserLoginParams
import com.android.watchlist.watchlist.domain.model_params.UserSignUpParams
import rx.Observable

/**
 * Created by alexanderpereu on 25.01.2018.
 */
class UserCloudDataStore (private val restApi: RestApi, private val dbHelper: DBHelper) : UserDataStore {

    override fun userLogin(login: UserLoginParams): Observable<UserEntity> {
        return restApi.user(login).doOnNext {
            dbHelper.saveUserCredential(it)
        }    }

    override fun userSign(sign: UserSignUpParams): Observable<UserEntity> {
        return restApi.user(sign).doOnNext {
            dbHelper.saveUserCredential(it)
        }     }
}