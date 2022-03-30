package com.emissa.apps.jokesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.emissa.apps.jokesapp.databinding.ActivityMainBinding
import com.emissa.apps.jokesapp.viewmodel.JokeViewModel
import com.emissa.apps.jokesapp.viewmodel.JokesViewModelFactory
import javax.inject.Inject

open class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: JokesViewModelFactory

    protected val mViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[JokeViewModel::class.java]
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    /**
     * TODO
     * have a welcome view instructing the user on what the app does and how to use it
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        JokesApp.jokesComponent.inject(this)
    }
}