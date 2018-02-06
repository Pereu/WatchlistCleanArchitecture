package com.watchlist.data.network.movie

import com.watchlist.data.entity.OnBoardingEntity
import com.watchlist.presentation.ui.fragments.LoginFragment
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
 * Created by alexanderpereu on 06.02.2018.
 */
class MovieRestApi @Inject constructor()  {

    private val service: MovieService

    init {
        val builder = OkHttpClient.Builder().addInterceptor(getLogginInterceptor())
        val retro = Retrofit.Builder()
                .baseUrl("http://apidev.filmgrail.com/apiv2_14/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build()).build()
        service = retro.create(MovieService::class.java)
    }

    private fun getLogginInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun getOnBoarding(take: Int, skip: Int) : Observable<ArrayList<OnBoardingEntity>> {
        return service.getOnBoardingMovie(LoginFragment.token, take, skip)
    }
}