package com.navermovie.daggerexamplewithnavermovie.domain

import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(query: String) = movieRepository.getMovieList(query)
}
