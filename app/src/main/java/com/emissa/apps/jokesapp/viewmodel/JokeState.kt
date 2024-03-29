package com.emissa.apps.jokesapp.viewmodel

sealed interface JokeState {
    object LOADING : JokeState
    class SUCCESS<T>(val response: T) : JokeState
    class ERROR(val error: Throwable) : JokeState
}