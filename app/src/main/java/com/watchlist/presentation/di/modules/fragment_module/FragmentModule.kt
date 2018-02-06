package com.watchlist.presentation.di.modules.fragment_module

import com.watchlist.data.repository.MovieDataRepository
import com.watchlist.data.repository.UserDataRepository
import com.watchlist.domain.repository.movie.MovieRepository
import com.watchlist.domain.repository.user.UserRepository
import com.watchlist.presentation.di.scopes.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * Created by alexanderpereu on 22.01.2018.
 */

@Module
class FragmentModule {

    @FragmentScope
    @Provides
    fun provideUserRepository(dataRepository: UserDataRepository): UserRepository {
        return dataRepository

    }
    @FragmentScope
    @Provides
    fun provideMovieRepository(dataRepository: MovieDataRepository): MovieRepository {
        return dataRepository

    }
}