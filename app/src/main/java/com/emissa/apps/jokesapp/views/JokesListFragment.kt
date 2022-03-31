package com.emissa.apps.jokesapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.emissa.apps.jokesapp.adapter.JokesAdapter
import com.emissa.apps.jokesapp.databinding.FragmentJokesListBinding
import com.emissa.apps.jokesapp.model.Joke
import com.emissa.apps.jokesapp.viewmodel.JokeState
import com.emissa.apps.jokesapp.viewmodel.JokeViewModel


class JokesListFragment : Fragment() {

    private val binding by lazy {
        FragmentJokesListBinding.inflate(layoutInflater)
    }

    private val mAdapter by lazy {
        JokesAdapter()
    }

    private val mViewModel: JokeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.jokesListRecycler.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = mAdapter
        }

        mViewModel.jokesLiveData.observe(viewLifecycleOwner) { state ->
            when(state) {
                is JokeState.LOADING -> {
                    Toast.makeText(
                        requireContext(),
                        "LOADING...",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is JokeState.SUCCESS<*> -> {
                    val jokes = state.response as List<Joke>
                    mAdapter.setJokes(jokes)
                }
                is JokeState.ERROR -> {
                    Toast.makeText(
                        requireContext(),
                        state.error.localizedMessage,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        mViewModel.getNumberOfJokes(20)
        // Inflate the layout for this fragment
        return binding.root
    }
}