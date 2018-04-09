package com.watchlist.domain.interactor.movie

import com.watchlist.domain.model.InCinemaMovie
import com.watchlist.domain.repository.movie.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by alexandr on 26/03/2018.
 */
class InCinemaInteractor
@Inject constructor(private val movieRepository: MovieRepository, private val todayDate: String) {

    private var take = 10
    private var skip = 0

    private var success: ((InCinemaMovie) -> Unit)? = null
    private var failure: ((String) -> Unit)? = null

    fun getInCinemaMovies(onSuccess: (InCinemaMovie) -> Unit, onFailure: (String) -> Unit) : Call<InCinemaMovie> {
        skip += take
        success = onSuccess
        failure = onFailure
        val call = movieRepository.getInCinemaMovies(take, skip, todayDate)
        call.enqueue(result)
        return call
    }

    private val result = object : Callback<InCinemaMovie> {
        override fun onResponse(call: Call<InCinemaMovie>, response: Response<InCinemaMovie>) {
            if (response.isSuccessful) {
                success?.invoke(response.body())
            }
        }

        override fun onFailure(call: Call<InCinemaMovie>, error: Throwable) {
            error.message?.let { failure?.invoke(it) }
        }
    }
}
