package com.navermovie.daggerexamplewithnavermovie.ui

import androidx.lifecycle.ViewModel
import com.navermovie.daggerexamplewithnavermovie.data.MovieUiState
import com.navermovie.daggerexamplewithnavermovie.domain.MovieUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val getMovieUseCase: MovieUseCase,
) : ViewModel() {
    private val _movieUiState = MutableStateFlow(emptyList<MovieUiState>())
    val movieUiState = _movieUiState.asStateFlow()

    suspend fun getMovieList(query: String) {
        _movieUiState.value = getMovieUseCase(query)
    }
}
