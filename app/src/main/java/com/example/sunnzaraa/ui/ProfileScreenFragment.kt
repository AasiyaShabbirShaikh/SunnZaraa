package com.example.sunnzaraa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sunnzaraa.R
import com.example.sunnzaraa.databinding.FragmentPremiumScreenBinding
import com.example.sunnzaraa.databinding.FragmentProfileScreenBinding

class ProfileScreenFragment : Fragment() {

    private lateinit var binding: FragmentProfileScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentProfileScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}