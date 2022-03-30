package com.emissa.apps.jokesapp.di

import com.emissa.apps.jokesapp.rest.JokeRepository
import com.emissa.apps.jokesapp.rest.JokeRepositoryImpl
import com.emissa.apps.jokesapp.rest.Services
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {
    @Provides
    fun provideNetworkService(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(Services.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(Services::class.java)

    @Provides
    fun providesOkHttpClient() =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    @Provides
    fun provideJokeRepository(services: Services): JokeRepository =
        JokeRepositoryImpl(services)
}