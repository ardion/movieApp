package com.example.movieapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MovieAdapter(private val dataSet: ArrayList<MovieItem>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleMoview: TextView
        val imageMovie: ImageView

        init {
            titleMoview = view.findViewById(R.id.titleMovie)
            imageMovie= view.findViewById(R.id.imageMovie)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.movie_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet[position]
        viewHolder.titleMoview.text = item.title
        Picasso.get().load("https://image.tmdb.org/t/p/original/"+item.image)
            .into(viewHolder.imageMovie)
    }

    override fun getItemCount() = dataSet.size

}