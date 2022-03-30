package com.emissa.apps.jokesapp.database

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.emissa.apps.jokesapp.model.Joke


@Database(
    entities = [Joke::class],
    version = 1
)
abstract class JokesDatabase: RoomDatabase() {
    abstract fun getJokesDap() : JokesDao
}

@Dao
interface JokesDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertJoke(newJokes: List<Joke>)

    @Query("SELECT * FROM joke WHERE id = :randomJoke")
    suspend fun getRandomJoke(randomJoke: Int) : Joke

//    @Query("SELECT * FROM joke WHERE")

    @Query("SELECT * FROM joke WHERE id = :jokeId")
    suspend fun getJokeById(jokeId: Int) : Joke

}