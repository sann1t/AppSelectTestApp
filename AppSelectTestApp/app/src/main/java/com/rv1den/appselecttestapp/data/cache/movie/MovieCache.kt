package com.rv1den.appselecttestapp.data.cache.movie

import com.rv1den.appselecttestapp.domain.model.MovieDomain
import kotlinx.coroutines.flow.Flow

interface MovieCache {
    fun setMovie(movies: List<MovieDomain>)
    fun getMovie(): Flow<List<MovieDomain>>
}