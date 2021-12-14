package com.rv1den.appselecttestapp.presentation.main

import com.rv1den.appselecttestapp.presentation.models.movies.MovieUI

sealed class MainScreenState {
    object Loading: MainScreenState()
    class Success(val movies: List<MovieUI>): MainScreenState()
}