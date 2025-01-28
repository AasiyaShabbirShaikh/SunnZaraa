package com.example.sunnzaraa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sunnzaraa.R
import com.example.sunnzaraa.databinding.FragmentMusicLanguagesScreenBinding

class MusicLanguagesScreenFragment : Fragment() {

    private lateinit var binding: FragmentMusicLanguagesScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicLanguagesScreenBinding.inflate(layoutInflater, container, false)

        musicLanguageOptionClick()
        return binding.root
    }

    private fun musicLanguageOptionClick(){
        binding.englishCardview.setOnClickListener {
            findNavController().navigate(R.id.albumScreenFragment)
        }

        binding.hindiCardview.setOnClickListener {
            findNavController().navigate(R.id.albumScreenFragment)
        }

        binding.marathiCardview.setOnClickListener {
            findNavController().navigate(R.id.albumScreenFragment)
        }

        binding.punjabiCardview.setOnClickListener {
            findNavController().navigate(R.id.albumScreenFragment)
        }

        binding.gujaratiCardview.setOnClickListener {
            findNavController().navigate(R.id.albumScreenFragment)
        }

        binding.southCardview.setOnClickListener {
            findNavController().navigate(R.id.albumScreenFragment)
        }

    }

}