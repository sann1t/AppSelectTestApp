package com.rv1den.appselecttestapp.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.rv1den.appselecttestapp.R
import com.rv1den.appselecttestapp.databinding.ActivityMainBinding
import com.rv1den.appselecttestapp.presentation.BaseActivity
import com.rv1den.appselecttestapp.presentation.core.viewBinding
import com.rv1den.appselecttestapp.presentation.main.adapters.MoviesAdapter
import com.rv1den.appselecttestapp.presentation.models.movies.MovieUI
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : BaseActivity(R.layout.activity_main) {

    private val viewBinding by viewBinding {
        ActivityMainBinding.bind(findViewById(R.id.mainContainer))
    }

    private val viewModel: MainViewModel by viewModels()

    private val moviesAdapter = MoviesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeScreenState()
    }

    private fun observeScreenState() = lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.screenState.collectLatest(::setState)
        }
    }

    private fun setState(screenState: MainScreenState) {
        when(screenState) {
            MainScreenState.Loading -> setLoadingState()
            is MainScreenState.Success -> setSuccessState(screenState.movies)
        }
    }

    private fun setLoadingState() = with(viewBinding){
        moviesProgressBar.isVisible = true
        moviesRecycleView.isVisible = false
    }

    private fun setSuccessState(movies: List<MovieUI>) = with(viewBinding){
        moviesRecycleView.adapter = moviesAdapter
        moviesAdapter.submitList(movies)

        moviesProgressBar.isVisible = false
        moviesRecycleView.isVisible = true
    }
}