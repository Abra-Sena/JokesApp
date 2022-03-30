package com.emissa.apps.jokesapp.rest

import com.emissa.apps.jokesapp.model.Joke
import com.emissa.apps.jokesapp.model.Jokes
import retrofit2.Response


interface JokeRepository {
    suspend fun getRandomJoke(): Response<Joke>
    suspend fun changeMainCharacter(firstName: String, lastName: String): Response<Joke>
    suspend fun getMultipleRandomJokes(jokesCount: Int): Response<Jokes>
    suspend fun getNumberOfJokes(jokesCount: Int): Response<Jokes>
    suspend fun getJokeById(jokeId: Int): Response<Joke>
}

class JokeRepositoryImpl(
    private val jokeServices: Services
): JokeRepository {
    override suspend fun getRandomJoke(): Response<Joke> {
        return jokeServices.getRandomJoke()
    }

    override suspend fun changeMainCharacter(firstName: String, lastName: String): Response<Joke> {
        return jokeServices.changeMainCharacter(firstName = firstName, lastName = lastName)
    }

    override suspend fun getMultipleRandomJokes(jokesCount: Int): Response<Jokes> {
        return jokeServices.getMultipleRandomJokes(jokesCount = jokesCount)
    }

    override suspend fun getNumberOfJokes(jokesCount: Int): Response<Jokes> {
        return jokeServices.getNumberOfJokes(jokesCount = jokesCount)
    }

    override suspend fun getJokeById(jokeId: Int): Response<Joke> {
        return jokeServices.getJokeById(jokeId = jokeId)
    }

}