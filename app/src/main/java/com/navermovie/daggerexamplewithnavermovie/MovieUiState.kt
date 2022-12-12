package com.navermovie.daggerexamplewithnavermovie

data class MovieUiState(
    val poster: String = "",
    val title: String = "",
    val director: String = "",
    val actors: String = "",
    val link: String = "",
)

fun MovieApiResponse.toMovieList() = items.map {
    MovieUiState(
        poster = it.image,
        title = it.title,
        director = it.director,
        actors = it.actor,
        link = it.link
    )
}
