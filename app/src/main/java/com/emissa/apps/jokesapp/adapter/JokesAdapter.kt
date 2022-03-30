package com.emissa.apps.jokesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emissa.apps.jokesapp.databinding.JokeItemBinding
import com.emissa.apps.jokesapp.model.Joke

class JokesAdapter(
    private val jokes: MutableList<Joke> = mutableListOf()
): RecyclerView.Adapter<JokeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        return JokeViewHolder(
            JokeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke = jokes[position]
        holder.bind(joke)
    }

    override fun getItemCount(): Int = jokes.size
}

class JokeViewHolder(
    private val binding: JokeItemBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(jokeItem: Joke) {
        binding.randomJokeView.text = jokeItem.joke
    }
}