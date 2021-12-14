package com.rv1den.appselecttestapp.di.network.api

import com.rv1den.appselecttestapp.data.cache.movie.MovieCache
import com.rv1den.appselecttestapp.data.cache.movie.MovieCacheService
import com.rv1den.appselecttestapp.data.movie.service.MoviesService
import com.rv1den.appselecttestapp.data.movie.service.MoviesUseCase
import com.rv1den.appselecttestapp.data.movie.service.RestMoviesRepository
import com.rv1den.appselecttestapp.domain.interactor.MoviesInteractor
import com.rv1den.appselecttestapp.domain.repositorie.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface MoviesNetworkModule {

    companion object {
        @Provides
        fun provideMoviesService(
            retrofit: Retrofit
        ): MoviesService = retrofit.create()
    }

    @Binds
    @Singleton
    fun bindMovieRepository(repository: RestMoviesRepository): MoviesRepository

    @Binds
    @Singleton
    fun bindMovieInteractor(moviesUseCase: MoviesUseCase): MoviesInteractor

    @Binds
    @Singleton
    fun bindMovieCacheService(movieCacheService: MovieCacheService): MovieCache
}