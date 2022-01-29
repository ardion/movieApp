package com.example.movieapplication

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

//class MovieRepository {
//    fun getMovie():List<MovieItem>{
//        var array= arrayListOf<MovieItem>()
//        array.add(MovieItem("","A"))
//        array.add(MovieItem("","A"))
//        array.add(MovieItem("","A"))
//        return array.toList()
//    }
//}

class MovieRepository @Inject constructor(private val service: MovieServiceExample) :
    IMovieRepository {


//    override suspend fun getMovies(
//        onResponse: (list: List<MovieItem>) -> Unit,
//        onFailure: (message: String) -> Unit
//    ) {
//        withContext(Dispatchers.IO) {
//            val call = service.getMovies()
//
//            call?.enqueue(object : Callback<GetMoviesResponse> {
//                override fun onResponse(
//                    call: Call<GetMoviesResponse>,
//                    response: Response<GetMoviesResponse>
//                ) {
//                    val list = response.body()?.results
//                    if (response.isSuccessful && list != null) {
//                        onResponse(list)
//                    } else {
//                        onResponse(listOf())
//                    }
//                }
//
//                override fun onFailure(call: Call<GetMoviesResponse>, t: Throwable) {
//                    onFailure("error")
//                }
//            })
//        }
//
//
//    }

    override suspend fun getMovies(
//        onResponse: (list: List<MovieItem>) -> Unit,
//        onFailure: (message: String) -> Unit
    ): Flow<List<MovieItem>> {

        return flow<List<MovieItem>> {
            try {
                val call = service.getMovies()
//                Log.d("coba", call.toString())
                val data = call.results
                if (data.isNotEmpty()) {
                    emit(data)
                } else emit(emptyList())

            } catch (e: Exception) {
                Log.e("handle error",e.toString())
            }

        }.flowOn(Dispatchers.IO)


//        withContext(Dispatchers.IO) {
//            val call = service.getMovies()
//
//            call?.enqueue(object : Callback<GetMoviesResponse> {
//                override fun onResponse(
//                    call: Call<GetMoviesResponse>,
//                    response: Response<GetMoviesResponse>
//                ) {
//                    val list = response.body()?.results
//                    if (response.isSuccessful && list != null) {
//                        onResponse(list)
//                    } else {
//                        onResponse(listOf())
//                    }
//                }
//
//                override fun onFailure(call: Call<GetMoviesResponse>, t: Throwable) {
//                    onFailure("error")
//                }
//            })
//        }


    }
}


