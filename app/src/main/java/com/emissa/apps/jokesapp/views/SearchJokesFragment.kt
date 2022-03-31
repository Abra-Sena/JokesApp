package com.emissa.apps.jokesapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.emissa.apps.jokesapp.databinding.FragmentSearchJokesBinding
import com.emissa.apps.jokesapp.viewmodel.JokeViewModel


class SearchJokesFragment : Fragment() {

    private val binding by lazy {
        FragmentSearchJokesBinding.inflate(layoutInflater)
    }
    private val mViewModel: JokeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }
}