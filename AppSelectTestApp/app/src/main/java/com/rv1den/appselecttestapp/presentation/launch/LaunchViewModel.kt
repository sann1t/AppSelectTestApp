package com.rv1den.appselecttestapp.presentation.launch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rv1den.appselecttestapp.domain.interactor.MoviesInteractor
import com.rv1den.appselecttestapp.navigation.container.ScreenContainer
import com.rv1den.appselecttestapp.navigation.container.ScreenContainerCoordinator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val screenContainerCoordinator: ScreenContainerCoordinator,
    private val moviesInteractor: MoviesInteractor
): ViewModel() {

    init {
     loadMovie()
    }

    private fun loadMovie() = viewModelScope.launch {
        moviesInteractor.getAllMovies().collect {
            screenContainerCoordinator.replace(ScreenContainer.Main)
        }
    }
}