package com.emissa.apps.jokesapp.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Joke(
    @SerializedName("categories")
    val categories: List<String>,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("joke")
    val joke: String
)