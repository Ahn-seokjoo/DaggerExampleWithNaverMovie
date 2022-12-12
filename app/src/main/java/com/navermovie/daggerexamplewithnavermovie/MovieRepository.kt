package com.navermovie.daggerexamplewithnavermovie

interface MovieRepository {
    suspend fun getMovieList(query: String): List<MovieUiState>
}
