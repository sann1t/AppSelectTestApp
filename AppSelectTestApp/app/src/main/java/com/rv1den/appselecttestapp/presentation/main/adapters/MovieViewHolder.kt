package com.rv1den.appselecttestapp.presentation.main.adapters

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rv1den.appselecttestapp.databinding.MovieItemBinding
import com.rv1den.appselecttestapp.presentation.models.movies.MovieUI

class MovieViewHolder(
    private val viewBinding: MovieItemBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(movie: MovieUI) = with(viewBinding){
        movieName.text = movie.name
        movieDescription.text = movie.description
        movieImage.load(movie.imageLink)
    }
}