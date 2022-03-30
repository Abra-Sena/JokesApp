package com.emissa.apps.jokesapp.network

import com.emissa.apps.jokesapp.model.Joke
import com.emissa.apps.jokesapp.model.Jokes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

sealed interface JokesService {
    // Fetching a random joke -> http://api.icndb.com/jokes/random
    @GET(RANDOM_JOKE)
    suspend fun getRandomJoke(): Response<Joke>

    // Changing name of the main character -> http://api.icndb.com/jokes/random?firstName=John&lastName=Doe
    @GET(RANDOM_JOKE)
    suspend fun changeMainCharacter(
        @Query("firstName") firstName: String,
        @Query("lastName") lastName: String
    ): Response<Joke>

    // Fetching multiple random jokes -> http://api.icndb.com/jokes/random/<number>
    @GET(RANDOM_JOKE)
    suspend fun getMultipleRandomJokes(
        @Query("number") jokesCount: Int
    ): Response<Jokes>

    // Fetching the number of jokes -> http://api.icndb.com/jokes/count
    @GET()
    suspend fun getNumberOfJokes(
        @Query("count") jokesCount: Int
    ): Response<Jokes>

    // Fetching a specific joke -> http://api.icndb.com/jokes/<id>
    @GET("{id}")
    suspend fun getJokeById(
        @Path("id") jokeId: Int
    ): Response<Joke>

    companion object {
        const val BASE_URL = "http://www.icndb.com/api/jokes/"
        private const val RANDOM_JOKE = "random"
    }
}

/**
 * Fetching a random joke -> http://api.icndb.com/jokes/random
 * Fetching multiple random jokes -> http://api.icndb.com/jokes/random/<number>
 * Fetching a specific joke -> http://api.icndb.com/jokes/<id>
 * Fetching the number of jokes -> http://api.icndb.com/jokes/count
 * Fetching the list of joke categories -> http://api.icndb.com/categories
 * Changing the name of the main character
 *  -> To do this, use the following GET parameters:
 *      - ?firstName=
 *      - ?lastName=
 *  Ex: http://api.icndb.com/jokes/random?firstName=John&lastName=Doe
 * Limiting categories
 *  -> http://api.icndb.com/jokes/random?limitTo=Array
 *  -> http://api.icndb.com/jokes/random?exclude=Array
 */