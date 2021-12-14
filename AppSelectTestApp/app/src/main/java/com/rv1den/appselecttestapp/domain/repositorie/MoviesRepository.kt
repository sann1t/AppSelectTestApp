package com.rv1den.appselecttestapp.domain.repositorie

import com.rv1den.appselecttestapp.domain.model.MovieDomain
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getAllMovies(): Flow<List<MovieDomain>>
}