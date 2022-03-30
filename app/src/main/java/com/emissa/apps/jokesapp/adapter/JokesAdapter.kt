package com.emissa.apps.jokesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.emissa.apps.jokesapp.databinding.JokeItemBinding
import com.emissa.apps.jokesapp.databinding.JokeItemDetaiilsBinding
import com.emissa.apps.jokesapp.model.Joke
import com.emissa.apps.jokesapp.utils.JOKE_ICONS

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
        binding.jokeView.text = jokeItem.joke
        binding.jokeCategory.text = jokeItem.categories.toString()
    }
}