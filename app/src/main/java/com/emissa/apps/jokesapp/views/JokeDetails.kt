package com.emissa.apps.jokesapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.emissa.apps.jokesapp.databinding.FragmentJokeDetailsBinding
import com.emissa.apps.jokesapp.model.Joke
import com.emissa.apps.jokesapp.utils.JOKE_ICONS
import com.emissa.apps.jokesapp.viewmodel.JokeViewModel


class JokeDetails : Fragment() {

    private val binding by lazy {
        FragmentJokeDetailsBinding.inflate(layoutInflater)
    }

    private val mViewModel: JokeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val chosenImage = JOKE_ICONS.shuffled()

//        fun bindDetails(jokeItem: Joke) {
//            bindingDetail.jokeId.text = jokeItem.id.toString()
//            bindingDetail.jokeView.text = jokeItem.joke
//            bindingDetail.jokeCategory.text = jokeItem.categories.toString()
//
//            Glide.with(binding.root)
//                .load(chosenImage)
//                .centerCrop()
//                .into(bindingDetail.randomImageView)
//        }
        // Inflate the layout for this fragment
        return binding.root
    }
}