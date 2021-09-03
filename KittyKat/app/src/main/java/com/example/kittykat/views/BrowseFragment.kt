package com.example.kittykat.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.kittykat.R
import com.example.kittykat.databinding.FragmentBrowseBinding


/**
 * A simple [Fragment] subclass.
 */
class BrowseFragment : Fragment(R.layout.fragment_browse) {

    private lateinit var binding: FragmentBrowseBinding

//    val navHostFragment =supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
//    val navController = navHostFragment.navController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBrowseBinding.bind(view)
    }


}