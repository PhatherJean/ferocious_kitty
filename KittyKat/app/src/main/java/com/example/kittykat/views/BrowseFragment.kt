package com.example.kittykat.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.kittykat.model.Kat
import com.example.kittykat.R
import com.example.kittykat.databinding.FragmentBrowseBinding
import com.example.kittykat.utils.ApiState
import com.example.kittykat.viewmodel.KatViewModel


/**
 * A simple [Fragment] subclass.
 */
class BrowseFragment : Fragment(R.layout.fragment_browse) {

    private val TAG = "BROWSE_FRAGMENT"

    private lateinit var binding: FragmentBrowseBinding

    private  val katViewModel by viewModels<KatViewModel>()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBrowseBinding.bind(view)
        initViews()
        setupObservers()
        katViewModel.fetchKatList(10)

        binding.btnSettings.setOnClickListener{
            val action = BrowseFragmentDirections.actionBrowseFragmentToSettingsFragment()
            findNavController().navigate(action)
        }

    }

    private fun initViews() = with(binding)
    { rvKats.adapter = KatAdapter() }

    private fun setupObservers() = with(katViewModel)
    {
        katState.observe(viewLifecycleOwner)
        {
                state -> binding.pbLoadin.isVisible = state is ApiState.Loading
            if (state is ApiState.Success) handleSuccess(state.data)
            if (state is ApiState.Failure) handleFailure(state.errorMsg)
        }

    }

    private fun handleSuccess(kat: List<Kat>)
    {
        (binding.rvKats.adapter as KatAdapter).updateList(kat)
    }
    private fun handleFailure(errorMsg : String)
    {
        System.out.println(errorMsg)
    }

}