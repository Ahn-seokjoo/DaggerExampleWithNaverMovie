package com.navermovie.daggerexamplewithnavermovie.domain

import com.navermovie.daggerexamplewithnavermovie.NetworkManager
import com.navermovie.daggerexamplewithnavermovie.data.MovieRepositoryImpl
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRepository: MovieRepositoryImpl = MovieRepositoryImpl(NetworkManager.movieApi),
) {
    suspend operator fun invoke(query: String) = movieRepository.getMovieList(query)
}
