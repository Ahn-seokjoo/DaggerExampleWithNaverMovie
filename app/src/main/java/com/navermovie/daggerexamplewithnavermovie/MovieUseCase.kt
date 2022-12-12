package com.navermovie.daggerexamplewithnavermovie

import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRepository: MovieRepositoryImpl = MovieRepositoryImpl(NetworkManager.movieApi),
) {
    suspend operator fun invoke(query: String) = movieRepository.getMovieList(query)
}
