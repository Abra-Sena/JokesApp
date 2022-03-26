package com.emissa.apps.jokesapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emissa.apps.jokesapp.databinding.FragmentSearchJokesBinding


class SearchJokesFragment : Fragment() {

    private val binding by lazy {
        FragmentSearchJokesBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }
}