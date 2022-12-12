package com.navermovie.daggerexamplewithnavermovie

import com.navermovie.daggerexamplewithnavermovie.data.MovieApi
import com.navermovie.daggerexamplewithnavermovie.data.MovieRepositoryImpl
import com.navermovie.daggerexamplewithnavermovie.domain.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun providesOkhttpClient() = OkHttpClient.Builder()
        .addInterceptor {
            it.proceed(
                it.request()
                    .newBuilder()
                    .addHeader("X-Naver-Client-Id", "7X1yGh22vxm3pKHFpPgi")
                    .addHeader("X-Naver-Client-Secret", "lwQAreXMyJ")
                    .build()
            )
        }.build()

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://openapi.naver.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun providesMovieApi(retrofit: Retrofit): MovieApi = retrofit.create()


}

@Module
abstract class BindRepositorys {
    @Singleton
    @Binds
    abstract fun bindsMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}
