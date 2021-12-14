package com.rv1den.appselecttestapp.data.movie.service

import com.rv1den.appselecttestapp.data.cache.movie.MovieCache
import com.rv1den.appselecttestapp.data.movie.service.models.toDomain
import com.rv1den.appselecttestapp.domain.model.MovieDomain
import com.rv1den.appselecttestapp.domain.repositorie.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RestMoviesRepository @Inject constructor(
    private val moviesService: MoviesService,
    private val movieCache: MovieCache
): MoviesRepository {
    override suspend fun getAllMovies(): Flow<List<MovieDomain>> {
        movieCache.setMovie(moviesService.getAllMovies().toDomain())
        return movieCache.getMovie()
    }
}