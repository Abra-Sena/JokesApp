package com.emissa.apps.jokesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.emissa.apps.jokesapp.R
import com.emissa.apps.jokesapp.databinding.JokeItemBinding
import com.emissa.apps.jokesapp.databinding.JokeItemDetaiilsBinding
import com.emissa.apps.jokesapp.model.Joke
import com.emissa.apps.jokesapp.utils.JOKE_ICONS

class JokesAdapter(
    private val jokes: MutableList<Joke> = mutableListOf()
): RecyclerView.Adapter<JokeViewHolder>() {

    fun setJokes(newJokes: List<Joke>) {
        jokes.clear()
        jokes.addAll(newJokes)
        notifyItemRangeChanged(0, itemCount)
    }

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
    val chosenImage = JOKE_ICONS.shuffled()

    fun bind(jokeItem: Joke) {
        binding.jokeView.text = jokeItem.joke
        binding.jokeView.compoundDrawablePadding = R.dimen.margin_tiny
        binding.jokeView.setCompoundDrawablesWithIntrinsicBounds(0, 0, chosenImage[0], 0)
    }
}