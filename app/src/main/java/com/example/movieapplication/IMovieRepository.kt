package com.example.movieapplication

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface IMovieRepository{
//    suspend fun getMovies(onResponse : (list : List<MovieItem>) -> Unit, onFailure : (message : String) -> Unit)

    suspend fun getMovies(): Flow<List<MovieItem>>
}