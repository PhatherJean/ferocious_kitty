package com.example.kittykat.model


import com.example.kittykat.model.Breed
import com.example.kittykat.model.Category
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Kat(

    val breeds: List<Breed>?,
    val categories: List<Category>?,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)