package com.emissa.apps.jokesapp.views

import androidx.fragment.app.Fragment
import com.emissa.apps.jokesapp.adapter.JokesAdapter

open class BaseFragment: Fragment() {
    protected val jokeAdapter by lazy {
        JokesAdapter()
    }
}