package com.example.kittykat.views

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kittykat.R
import com.example.kittykat.databinding.FragmentSettingsBinding


/**
 * A simple [Fragment] subclass.
 */
class SettingsFragment : Fragment(R.layout.fragment_settings) {

  private lateinit var binding: FragmentSettingsBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = FragmentSettingsBinding.bind(view)

    binding.btnSubmit.setOnClickListener {
      val num = binding.editTextNum.text.toString().toInt()
      if (num > 100)
      {
        val action = SettingsFragmentDirections.actionSettingsFragmentToBrowseFragment(1)
        findNavController().navigate(action)
      }
      else
      {
        val action = SettingsFragmentDirections.actionSettingsFragmentToBrowseFragment(num)
        findNavController().navigate(action)
      }

    }

    binding.btnCancel.setOnClickListener{
      val num = 10
      findNavController().navigate(SettingsFragmentDirections.actionSettingsFragmentToBrowseFragment(num))
    }

  }
}