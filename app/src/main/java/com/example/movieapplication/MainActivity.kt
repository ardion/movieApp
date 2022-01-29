package com.example.movieapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    private val viewModel:MovieViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

//        val rvMovie:RecyclerView
//
//        rvMovie=findViewById(R.id.rvMovie)
//        val retrofit=RetrofitClient().getRetrofitInstance()
//        val serviceMovie = retrofit?.create(MovieServiceExample::class.java)
//        val repository=  MovieRepository(service = serviceMovie)
//        val factory=MovieViewModel.Factory(repository)

//
//        viewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)

        viewModel.movie.observe(this,{
            viewBinding.rvMovie.apply {
                adapter=MovieAdapter(it as ArrayList<MovieItem>)
            }
            })



    }
}