package com.navermovie.daggerexamplewithnavermovie

import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val movieApi: MovieApi) : MovieRepository {
    override suspend fun getMovieList(query: String): List<MovieUiState> {
        return movieApi.getMovieList(query).toMovieList()
    }
}
