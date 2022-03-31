package com.emissa.apps.jokesapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.emissa.apps.jokesapp.R
import com.emissa.apps.jokesapp.databinding.FragmentMainBinding
import com.emissa.apps.jokesapp.viewmodel.JokeViewModel


class MainFragment : Fragment() {

    private val binding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    private val mViewModel: JokeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.btnJokeList.setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_JokesListFragment)
        }

        binding.btnSearchForJoke.setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_SearchForJokes)
        }

        binding.btnRandomJoke.setOnClickListener {
            RandomJokeFragment().show(parentFragmentManager, "random")
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}