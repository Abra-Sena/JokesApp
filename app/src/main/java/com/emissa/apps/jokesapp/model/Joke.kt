package com.emissa.apps.jokesapp.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Joke(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("joke")
    val joke: String
//    @SerializedName("categories")
//    val categories: List<String?> = listOfNotNull(null)
)

// allow the database to save  a list inside
// use a type converter to save the list as a Json
// adapter to convert