package com.emissa.apps.jokesapp.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(
    private val applicationContext: Context
) {
    @Provides
    fun provideContext() : Context { return applicationContext }
}