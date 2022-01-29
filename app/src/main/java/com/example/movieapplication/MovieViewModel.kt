package com.example.movieapplication

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: IMovieRepository) : ViewModel() {
    private var _movie = MutableLiveData<List<MovieItem>>()
    val movie: LiveData<List<MovieItem>> = _movie

//    val coroutineScope = CoroutineScope(Job() + Dispatchers.Main)

    init {
        getMovie()
    }

//    private fun getMovie() {
//        coroutineScope.launch {
//            repository.getMovies({
//                _movie.value = it
//            }, {
//                print(it)
//            })
//        }
//
////        }
//    }

    private fun getMovie() {
        viewModelScope.launch {
            repository.getMovies()
                .collect {
                _movie.value=it
            }
        }

//        }
    }

//
//    class Factory ( private val repository: MovieRepository) : ViewModelProvider.Factory {
//        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//            if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
//                @Suppress("UNCHECKED_CAST")
//                return MovieViewModel(repository) as T
//            }
//            throw IllegalArgumentException("Unable to construct viewmodel")
//        }
//    }
}