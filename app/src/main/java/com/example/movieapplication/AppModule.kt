package com.example.movieapplication

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule{
    @Binds
    abstract fun provideMovieRepository(movieRepository: MovieRepository):IMovieRepository
}
