package com.example.movieapplication

import android.graphics.Movie
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    private val BASE_URL = "https://api.themoviedb.org"

//    @Singleton
//    @Provides
//    fun getRepo(service:MovieServiceExample): IMovieRepository {
//        return MovieRepository(service)
//
//    }

    @Singleton
    @Provides
    fun getApiServiceInstance(retrofit: Retrofit):MovieServiceExample{
        return retrofit.create(MovieServiceExample::class.java)
    }


    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }



}



