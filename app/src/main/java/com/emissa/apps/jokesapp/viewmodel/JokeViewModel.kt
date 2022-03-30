package com.emissa.apps.jokesapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emissa.apps.jokesapp.rest.JokeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import kotlin.Exception

class JokeViewModel(
    private val jokeRepo: JokeRepository,
    private var coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {
    private val _jokesLiveData: MutableLiveData<JokeState> = MutableLiveData(JokeState.LOADING)
    val jokesLiveData: LiveData<JokeState> get() = _jokesLiveData

    private val _mainCharacter: MutableLiveData<String> = MutableLiveData()
    private val mainCharacter: MutableLiveData<String> get() = _mainCharacter

    fun getRandomJoke() {
        _jokesLiveData.postValue(JokeState.LOADING)

        viewModelScope.launch(coroutineDispatcher) {
            checkResponse(
                jokeRepo.getRandomJoke(),
                "Retrieving Random Joke"
            )
        }
    }

    fun changeMainCharacter(first: String, last: String) {
        _jokesLiveData.postValue(JokeState.LOADING)

        viewModelScope.launch(coroutineDispatcher) {
            checkResponse(
                jokeRepo.changeMainCharacter(first, last),
                "Changing Main Character"
            )
        }
    }

    fun getMultipleRandomJokes(count: Int) {
        _jokesLiveData.postValue(JokeState.LOADING)

        viewModelScope.launch(coroutineDispatcher) {
            checkResponse(
                jokeRepo.getMultipleRandomJokes(count),
                "Retrieving $count Random Jokes"
            )
        }
    }

    fun getNumberOfJokes(count: Int) {
        _jokesLiveData.postValue(JokeState.LOADING)

        viewModelScope.launch(coroutineDispatcher) {
            checkResponse(
                jokeRepo.getNumberOfJokes(count),
                "Retrieving $count Jokes"
            )
        }
    }

    fun getJokeById(id: Int) {
        _jokesLiveData.postValue(JokeState.LOADING)

        viewModelScope.launch(coroutineDispatcher) {
            checkResponse(
                jokeRepo.getJokeById(id),
                "Retrieving Joke with ID = $id"
            )
        }
    }

    private fun <T> checkResponse(response: Response<T>, message: String) {
        try {
            if (response.isSuccessful) {
                response.body()?.let {
                    _jokesLiveData.postValue(JokeState.SUCCESS(it))
                } ?: throw Exception("$message -> No response!")
            } else throw Exception("$message -> Unsuccessful!")
        } catch (e: Exception) {
            _jokesLiveData.postValue(JokeState.ERROR(e))
        }
    }
//            try {
//                val response = jokeRepo.getRandomJoke()
//
//            } catch (e: Exception) {
//                _jokesLiveData.postValue(JokeState.ERROR(e))
//            }
}