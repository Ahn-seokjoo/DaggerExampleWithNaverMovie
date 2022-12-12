package com.navermovie.daggerexamplewithnavermovie.data


import com.google.gson.annotations.SerializedName

data class MovieApiResponse(
    @SerializedName("items")
    val items: List<Movie>,
) {
    data class Movie(
        @SerializedName("actor")
        val actor: String,
        @SerializedName("director")
        val director: String,
        @SerializedName("image")
        val image: String,
        @SerializedName("link")
        val link: String,
        @SerializedName("pubDate")
        val pubDate: String,
        @SerializedName("subtitle")
        val subtitle: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("userRating")
        val userRating: String,
    )
}
