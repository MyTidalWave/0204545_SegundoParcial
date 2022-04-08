package com.lharo.exam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(context: Context, feedEntries: ArrayList<MovieModel>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var localContext: Context? = null
    private var localFeedEntries: ArrayList<MovieModel>? = null

    init {
        localContext = context
        localFeedEntries = feedEntries
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(localContext)
        val view: View = layoutInflater.inflate(R.layout.cards, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        val currentFeedEntry: MovieModel = localFeedEntries!![position]
        holder.textTitle.text = currentFeedEntry.title
        holder.textVotes.text = currentFeedEntry.imdbVotes
        holder.textRating.text = currentFeedEntry.imdbRating
        holder.textScore.text = currentFeedEntry.metascore
    }

    override fun getItemCount(): Int {
        return localFeedEntries?.size ?:0
    }

    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {

        val textTitle: TextView = v.findViewById(R.id.textViewTitle)
        val textVotes: TextView = v.findViewById(R.id.textViewVotes)
        val textRating: TextView = v.findViewById(R.id.textViewRating)
        val textScore: TextView = v.findViewById(R.id.textViewScore)

    }
}