package com.emissa.apps.jokesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emissa.apps.jokesapp.rest.JokeRepository
import javax.inject.Inject

class JokesViewModelFactory @Inject constructor(
    private val jokeRepo: JokeRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return JokeViewModel(jokeRepo) as T
    }

}