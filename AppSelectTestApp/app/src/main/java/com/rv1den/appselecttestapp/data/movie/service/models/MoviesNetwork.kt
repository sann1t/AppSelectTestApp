package com.rv1den.appselecttestapp.data.movie.service.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesNetwork(
    @SerialName("results")
    val results: List<ResultNetwork>,
)