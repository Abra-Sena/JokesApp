package com.emissa.apps.jokesapp

import android.app.Application
import com.emissa.apps.jokesapp.di.ApplicationModule
import com.emissa.apps.jokesapp.di.DaggerJokesComponent
import com.emissa.apps.jokesapp.di.JokesComponent

class JokesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        jokesComponent = DaggerJokesComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    companion object {
        lateinit var jokesComponent: JokesComponent
    }
}