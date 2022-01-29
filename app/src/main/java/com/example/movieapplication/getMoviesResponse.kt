package com.example.movieapplication

data class GetMoviesResponse(
    val page: Int,
    val results: List<MovieItem>
)