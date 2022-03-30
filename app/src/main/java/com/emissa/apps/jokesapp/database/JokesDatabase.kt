package com.emissa.apps.jokesapp.database

import android.content.Context
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.emissa.apps.jokesapp.model.Joke


@Database(
    entities = [Joke::class],
    version = 1,
    exportSchema = false
)
abstract class JokesDatabase: RoomDatabase() {
    abstract fun getJokesDa0() : JokesDao

    companion object {
        @Volatile
        private var INSTANCE: JokesDatabase? = null

        fun getJokesDatabase(context: Context): JokesDatabase {
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JokesDatabase::class.java,
                    "jokes_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
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