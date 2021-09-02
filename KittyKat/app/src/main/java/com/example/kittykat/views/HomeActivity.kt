package com.example.kittykat.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kittykat.R
import com.example.kittykat.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    //lateinit is like a contract with app to initial error
    private lateinit var name : String

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    // var is mutable can change
    // val is const and cant change
    // lazy only init when I call this actual variable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}