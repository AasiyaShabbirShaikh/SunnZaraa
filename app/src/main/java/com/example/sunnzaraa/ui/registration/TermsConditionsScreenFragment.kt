package com.example.sunnzaraa.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.sunnzaraa.R
import com.example.sunnzaraa.databinding.FragmentPersonalDetailsScreenBinding
import com.example.sunnzaraa.databinding.FragmentTermsConditionsScreenBinding
import com.example.sunnzaraa.ui.registration.viewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TermsConditionsScreenFragment : Fragment() {

    private lateinit var binding: FragmentTermsConditionsScreenBinding

    private val authViewModel by activityViewModels<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTermsConditionsScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleSignUpButton()
    }

    private fun handleSignUpButton() {
        binding.signupButton.setOnClickListener {
            if (!binding.acceptCheckbox.isChecked) {
                Toast.makeText(
                    requireContext(),
                    "Please accept the terms to continue",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            authViewModel.registerTempData()
        }

        observeRegistrationResult()


        }

    private fun observeRegistrationResult(){
        authViewModel.registerResult.observe(viewLifecycleOwner) { result ->
            result.onSuccess {
                Toast.makeText(requireContext(), "Registration successful!", Toast.LENGTH_SHORT).show()

                val navController = requireActivity().findNavController(R.id.container)
                val navGraph = navController.navInflater.inflate(R.navigation.dashboard_nav_graph)
                navController.graph = navGraph
            }

            result.onFailure {
                Toast.makeText(requireContext(), "Registration failed: ${it.message}", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
