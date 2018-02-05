package com.android.watchlist.watchlist.data.repository.datasourse

import com.android.watchlist.watchlist.data.data_base.DBHelper
import com.android.watchlist.watchlist.data.network.RestApi
import javax.inject.Inject

/**
 * Created by alexanderpereu on 25.01.2018.
 */
class UserDataFactory @Inject constructor(private val restApi: RestApi, val dbHelper: DBHelper)  {

    fun createCloudDataStore(): UserDataStore {
        return UserCloudDataStore(restApi, dbHelper)
    }
}