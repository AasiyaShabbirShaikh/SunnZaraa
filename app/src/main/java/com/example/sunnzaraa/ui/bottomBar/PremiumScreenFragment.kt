package com.example.sunnzaraa.ui.bottomBar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sunnzaraa.databinding.FragmentPremiumScreenBinding

class PremiumScreenFragment : Fragment() {

    private lateinit var binding: FragmentPremiumScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPremiumScreenBinding.inflate(layoutInflater, container, false)

        binding.closeBtn.setOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }

}