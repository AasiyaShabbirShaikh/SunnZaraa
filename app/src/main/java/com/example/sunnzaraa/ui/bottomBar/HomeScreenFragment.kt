package com.example.sunnzaraa.ui.bottomBar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.sunnzaraa.R
import com.example.sunnzaraa.databinding.FragmentHomeScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeScreenFragment : Fragment() {

    private var _binding : FragmentHomeScreenBinding? = null
    private val binding: FragmentHomeScreenBinding  get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            favouritesButton.setOnClickListener {
                findNavController().navigate(HomeScreenFragmentDirections.actionHomeScreenFragmentToFavouritesScreenFragment())
            }

            podcastButton.setOnClickListener {
                findNavController().navigate(HomeScreenFragmentDirections.actionHomeScreenFragmentToPodcastScreenFragment())
            }
        }
    }


}