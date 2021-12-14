package com.rv1den.appselecttestapp.data.movie.service.models

import com.rv1den.appselecttestapp.domain.model.MovieDomain

fun MoviesNetwork.toDomain(): List<MovieDomain> {
    return results.map { result ->
        MovieDomain(
            name = result.displayTitle,
            description = result.summaryShort,
            imageLink = result.multimedia.src
        )
    }
}