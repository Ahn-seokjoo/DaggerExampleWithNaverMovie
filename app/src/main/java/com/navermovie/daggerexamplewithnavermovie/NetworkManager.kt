package com.navermovie.daggerexamplewithnavermovie

import com.navermovie.daggerexamplewithnavermovie.data.MovieApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object NetworkManager {
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor {
            it.proceed(
                it.request()
                    .newBuilder()
                    .addHeader("X-Naver-Client-Id", "7X1yGh22vxm3pKHFpPgi")
                    .addHeader("X-Naver-Client-Secret", "lwQAreXMyJ")
                    .build()
            )
        }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://openapi.naver.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val movieApi: MovieApi = retrofit.create()
}
