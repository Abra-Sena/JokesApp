package com.emissa.apps.jokesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emissa.apps.jokesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

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
    }
}