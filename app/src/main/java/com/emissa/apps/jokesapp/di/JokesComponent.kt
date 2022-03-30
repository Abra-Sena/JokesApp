package com.emissa.apps.jokesapp.di

import com.emissa.apps.jokesapp.MainActivity
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface JokesComponent {
    fun inject(mainActivity: MainActivity)
}