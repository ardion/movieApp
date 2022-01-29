package com.example.movieapplication

import com.google.gson.annotations.SerializedName

data class MovieItem(
    @SerializedName("poster_path")
    val image: String,
    @SerializedName("title")
    val title: String
)