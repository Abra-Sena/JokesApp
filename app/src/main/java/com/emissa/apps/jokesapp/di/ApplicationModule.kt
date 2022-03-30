package com.emissa.apps.jokesapp.di

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import com.emissa.apps.jokesapp.database.DatabaseRepository
import com.emissa.apps.jokesapp.database.DatabaseRepositoryImpl
import com.emissa.apps.jokesapp.database.JokesDao
import com.emissa.apps.jokesapp.database.JokesDatabase
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(
    private val applicationContext: Context
) {
    @Provides
    fun provideContext() : Context { return applicationContext }

    @Provides
    fun provideConnectivityManager(context: Context): ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    @Provides
    fun provideNetworkRequest() : NetworkRequest {
        return NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
    }

    @Provides
    fun provideJokeDatabase(context: Context): JokesDatabase {
        return JokesDatabase.getJokesDatabase(context)
    }

    @Provides
    fun provideJokesDao(database: JokesDatabase) : JokesDao = database.getJokesDa0()

    @Provides
    fun provideJokeRepository(dao: JokesDao): DatabaseRepository = DatabaseRepositoryImpl(dao)
}