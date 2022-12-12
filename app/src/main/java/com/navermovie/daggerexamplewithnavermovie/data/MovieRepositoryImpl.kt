package com.navermovie.daggerexamplewithnavermovie.data

import com.navermovie.daggerexamplewithnavermovie.domain.MovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(private val movieApi: MovieApi) : MovieRepository {
    override suspend fun getMovieList(query: String): List<MovieUiState> {
        return movieApi.getMovieList(query).toMovieList()
    }
}
