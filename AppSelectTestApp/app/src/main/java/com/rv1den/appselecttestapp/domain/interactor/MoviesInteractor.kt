package com.rv1den.appselecttestapp.domain.interactor

import com.rv1den.appselecttestapp.domain.model.MovieDomain
import kotlinx.coroutines.flow.Flow

interface MoviesInteractor {
    suspend fun getAllMovies(): Flow<List<MovieDomain>>
}