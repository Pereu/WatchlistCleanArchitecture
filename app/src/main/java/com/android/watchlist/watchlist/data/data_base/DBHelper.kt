package com.android.watchlist.watchlist.data.data_base

import com.android.watchlist.watchlist.data.entity.UserEntity
import io.realm.Realm
import io.realm.kotlin.createObject

/**
 * Created by alexanderpereu on 25.01.2018.
 */
class DBHelper {

    fun saveUserCredential(userLogin: UserEntity) {
        val realm = Realm.getDefaultInstance()
        try {
                realm.executeTransaction {
                    // Save User
                    val user = realm.createObject<UserEntity>()
                    with(user) {
                        this.Token = userLogin.Token
                        this.UserInfo = userLogin.UserInfo
                        this.UserName = userLogin.UserName
                    }
                }
            } catch (e: Exception) {
                print(e)
            } finally {
                realm.close()
            }
        }
        /*  realm.beginTransaction()
          realm.copyToRealmOrUpdate(github)
          realm.commitTransaction()
          */
    }

//    fun get(id: String): Observable<GithubEntity> {
//        return Observable.create { subscriber ->
//            val savedUser: GithubEntity? = RealmQuery.createQuery(realm,
//                    GithubEntity::class.java).equalTo("UserName", id)
//                    .findFirst()
//            if (savedUser != null) {
//                subscriber.onNext(savedUser)
//                subscriber.onCompleted()
//            } else subscriber.onError(Throwable())
//
//        }
//    }
