package com.watchlist.data.entity.mapper

import com.watchlist.data.entity.UserEntity
import com.watchlist.domain.model.User
import javax.inject.Inject

/**
 * Created by alexanderpereu on 25.01.2018.
 */
class UserMapper @Inject constructor() : EntryEntityMapper<User, UserEntity>() {

    override fun transform(entity: UserEntity?): User? {
        if (entity != null) {
            val user = User()
            with(user) {
                UserInfo = entity.UserInfo
                Token = entity.Token
                UserName = entity.UserName
            }
            return user
        }
        return null
    }
}