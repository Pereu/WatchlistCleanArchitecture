package com.android.watchlist.watchlist.data.entity

import io.realm.RealmObject

/**
 * Created by alexanderpereu on 25.01.2018.
 */
open class UserEntity : RealmObject() {
    open var UserInfo  = ""
    open var Token = ""
    open var UserName = ""
}