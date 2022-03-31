package com.emissa.apps.jokesapp.di

import com.emissa.apps.jokesapp.MainActivity
import dagger.Component

@Component(
    modules = [
        NetworkModule::class,
        ApplicationModule::class,
    ]
)
interface JokesComponent {
    fun inject(mainActivity: MainActivity)
}