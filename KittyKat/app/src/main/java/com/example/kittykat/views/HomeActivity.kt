package com.example.kittykat.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.kittykat.R
import com.example.kittykat.databinding.ActivityHomeBinding
import com.example.kittykat.viewmodel.KatViewModel

class HomeActivity : AppCompatActivity() {
    //lateinit is like a contract with app to initial error

    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }
    // var is mutable can change
    // val is const and cant change
    // lazy only init when I call this actual variable

    private val katViewModel by viewModels<KatViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}