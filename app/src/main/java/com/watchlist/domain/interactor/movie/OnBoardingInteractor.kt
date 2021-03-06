package com.watchlist.domain.interactor.movie

import com.watchlist.domain.model.OnBoardingMovie
import com.watchlist.domain.repository.movie.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by alexanderpereu on 05.02.2018.
 */
class OnBoardingInteractor
@Inject constructor(private val movieRepository: MovieRepository) {

    private var take = 10
    private var skip = 0

    private var success: ((ArrayList<OnBoardingMovie>) -> Unit)? = null
    private var failure: ((String) -> Unit)? = null

    fun getOnBoarding(onSuccess: (ArrayList<OnBoardingMovie>) -> Unit, onFailure: (String) -> Unit)  {
        skip += take
        success = onSuccess
        failure = onFailure
        val call = movieRepository.getNewOnBoarding(take, skip)
        call.enqueue(result)
    }

    private val result = object : Callback<ArrayList<OnBoardingMovie>> {
        override fun onResponse(call: Call<ArrayList<OnBoardingMovie>>, response: Response<ArrayList<OnBoardingMovie>>) {
            if (response.isSuccessful) {
                success?.invoke(response.body())
            }
        }

        override fun onFailure(call: Call<ArrayList<OnBoardingMovie>>, error: Throwable) {
            error.message?.let { failure?.invoke(it) }
        }
    }
}


