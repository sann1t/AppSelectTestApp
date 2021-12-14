package com.rv1den.appselecttestapp.data.cache.movie

import com.rv1den.appselecttestapp.domain.model.MovieDomain
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MovieCacheService @Inject constructor(): MovieCache {

    private val mutableMoviesState = MutableStateFlow<List<MovieDomain>>(emptyList())

    override fun setMovie(movies: List<MovieDomain>) {
        mutableMoviesState.value = movies
    }

    override fun getMovie(): Flow<List<MovieDomain>> {
        return flowOf(mutableMoviesState.value)
    }
}