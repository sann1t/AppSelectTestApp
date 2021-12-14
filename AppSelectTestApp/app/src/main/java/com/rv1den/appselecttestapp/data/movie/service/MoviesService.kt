package com.rv1den.appselecttestapp.data.movie.service

import com.rv1den.appselecttestapp.data.movie.service.models.MoviesNetwork
import retrofit2.http.GET


interface MoviesService {

    @GET("reviews/all.json")
    suspend fun getAllMovies(): MoviesNetwork
}