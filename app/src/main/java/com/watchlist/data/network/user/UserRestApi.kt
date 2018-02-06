package com.watchlist.data.network.user

import com.watchlist.data.entity.UserEntity
import com.watchlist.domain.model_params.UserLoginParams
import com.watchlist.domain.model_params.UserSignUpParams
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import javax.inject.Inject

/**
 * Created by alexanderpereu on 25.01.2018.
 */
class UserRestApi @Inject constructor()  {

    private val service: UserService

    init {
        val builder = OkHttpClient.Builder().addInterceptor(getLogginInterceptor())
        val retro = Retrofit.Builder()
                .baseUrl("http://apidev.filmgrail.com/apiv2_14/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build()).build()
        service = retro.create(UserService::class.java)
    }

    private fun getLogginInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun user(login: UserLoginParams): Observable<UserEntity> {
        return service.loginUser(login)
    }

    fun user(sign: UserSignUpParams): Observable<UserEntity> {
        return service.signUpUser(sign)
    }

}