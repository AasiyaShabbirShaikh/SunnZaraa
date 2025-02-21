package com.example.sunnzaraa.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sunnzaraa.R
import com.example.sunnzaraa.databinding.FragmentPersonalDetailsScreenBinding
import com.example.sunnzaraa.databinding.ItemSongLayoutBinding

class PersonalDetailsScreenFragment : Fragment() {

    private lateinit var binding: FragmentPersonalDetailsScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonalDetailsScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNextButtonEvent()
    }

    private fun handleNextButtonEvent(){
        binding.nextButton.setOnClickListener {
            findNavController().navigate(PersonalDetailsScreenFragmentDirections.actionPersonalDetailsScreenFragmentToTermsConditionsScreenFragment())
        }
    }
}