package com.watchlist.data.network.movie

import com.google.gson.Gson
import com.watchlist.domain.model.InCinemaMovie
import com.watchlist.domain.model.OnBoardingMovie
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
                .client(builder.build()).build()
        service = retro.create(MovieService::class.java)
    }

    private fun getLogginInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun getInCinemaMovies(token: String, take: Int, skip: Int, todayDate: String): Call<InCinemaMovie> {
        return service.getInCinemaMovies(token, "Bergen", take, skip, "in-cinema", todayDate, true)
    }

    fun getNewOnBoarding(token: String, take: Int, skip: Int): Call<ArrayList<OnBoardingMovie>> {
        return service.getNewOnBoardingMovie(token, take, skip)
    }
}