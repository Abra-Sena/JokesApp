package com.emissa.apps.jokesapp.database

import com.emissa.apps.jokesapp.model.Joke

interface DatabaseRepository {
    suspend fun insertJoke(newJokes: List<Joke>)
    suspend fun getRandomJoke(randomJoke: Int) : Joke
    suspend fun getJokeById(jokeId: Int) : Joke
}

class DatabaseRepositoryImpl(
    private val jokesDao: JokesDao
): DatabaseRepository {
    override suspend fun insertJoke(newJokes: List<Joke>) {
        jokesDao.insertJoke(newJokes)
    }

    override suspend fun getRandomJoke(randomJoke: Int): Joke {
        return jokesDao.getRandomJoke(randomJoke)
    }

    override suspend fun getJokeById(jokeId: Int): Joke {
        return jokesDao.getJokeById(jokeId)
    }
}