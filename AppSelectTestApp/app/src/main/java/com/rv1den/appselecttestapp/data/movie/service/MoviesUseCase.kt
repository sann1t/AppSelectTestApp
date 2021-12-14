package com.rv1den.appselecttestapp.data.movie.service

import com.rv1den.appselecttestapp.domain.interactor.MoviesInteractor
import com.rv1den.appselecttestapp.domain.model.MovieDomain
import com.rv1den.appselecttestapp.domain.repositorie.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
): MoviesInteractor {
    override suspend fun getAllMovies(): Flow<List<MovieDomain>> {
        return moviesRepository.getAllMovies()
    }
}