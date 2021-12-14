package com.rv1den.appselecttestapp.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rv1den.appselecttestapp.domain.interactor.MoviesInteractor
import com.rv1den.appselecttestapp.presentation.models.movies.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val moviesInteractor: MoviesInteractor
) : ViewModel() {

    init {
        getMovies()
    }

    private val mutableScreenState = MutableStateFlow<MainScreenState>(MainScreenState.Loading)
    val screenState = mutableScreenState.asStateFlow()

    private fun getMovies() = viewModelScope.launch {
        moviesInteractor.getAllMovies().collectLatest { movies ->
            mutableScreenState.value = MainScreenState.Success(
                movies.map { movie ->
                    movie.toUI()
                }
            )
        }
    }
}