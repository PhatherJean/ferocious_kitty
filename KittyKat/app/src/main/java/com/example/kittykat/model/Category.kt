package com.example.kittykat.model


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Category(
    val id: Int?,
    val name: String?
)