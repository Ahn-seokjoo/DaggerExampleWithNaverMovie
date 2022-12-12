package com.navermovie.daggerexamplewithnavermovie.domain

import com.navermovie.daggerexamplewithnavermovie.data.MovieUiState

interface MovieRepository {
    suspend fun getMovieList(query: String): List<MovieUiState>
}
