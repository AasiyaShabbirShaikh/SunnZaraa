package com.example.sunnzaraa.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.sunnzaraa.R
import com.example.sunnzaraa.databinding.FragmentPersonalDetailsScreenBinding
import com.example.sunnzaraa.databinding.FragmentTermsConditionsScreenBinding

class TermsConditionsScreenFragment : Fragment() {
    private lateinit var binding: FragmentTermsConditionsScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTermsConditionsScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signupButton.setOnClickListener {
            if(binding.acceptCheckbox.isChecked){
                handleSignUpButton()
            }
            else{
                Toast.makeText(requireContext(),getString(R.string.accept_toast_text), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun handleSignUpButton(){
            val navController = requireActivity().findNavController(R.id.container)
            val navGraph = navController.navInflater.inflate(R.navigation.dashboard_nav_graph)
            navController.graph = navGraph
    }
}