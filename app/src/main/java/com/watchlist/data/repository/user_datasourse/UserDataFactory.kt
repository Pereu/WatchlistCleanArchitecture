package com.watchlist.data.repository.user_datasourse

import com.watchlist.data.data_base.DBHelper
import com.watchlist.data.network.user.UserRestApi
import javax.inject.Inject

/**
 * Created by alexanderpereu on 25.01.2018.
 */
class UserDataFactory @Inject constructor(private val restApi: UserRestApi, val dbHelper: DBHelper)  {

    fun createCloudDataStore(): UserDataStore {
        return UserCloudDataStore(restApi, dbHelper)
    }
}