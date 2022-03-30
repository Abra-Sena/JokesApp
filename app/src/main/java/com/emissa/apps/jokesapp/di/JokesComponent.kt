package com.emissa.apps.jokesapp.di

import com.emissa.apps.jokesapp.MainActivity
import dagger.Component

@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface JokesComponent {
    fun inject(mainActivity: MainActivity)
}