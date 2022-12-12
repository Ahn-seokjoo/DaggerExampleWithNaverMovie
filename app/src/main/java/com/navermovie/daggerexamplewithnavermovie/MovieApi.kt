package com.navermovie.daggerexamplewithnavermovie

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("v1/search/movie.json")
    suspend fun getMovieList(
        @Query("query") query: String,
    ): MovieApiResponse
}
