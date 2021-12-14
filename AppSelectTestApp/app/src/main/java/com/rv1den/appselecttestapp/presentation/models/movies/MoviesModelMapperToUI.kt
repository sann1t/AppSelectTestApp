package com.rv1den.appselecttestapp.presentation.models.movies

import com.rv1den.appselecttestapp.domain.model.MovieDomain

fun MovieDomain.toUI(): MovieUI {
    return MovieUI(
        name,
        description,
        imageLink
    )
}