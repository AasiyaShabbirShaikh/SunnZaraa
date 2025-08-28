package com.example.sunnzaraa.ui.registration

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sunnzaraa.R
import com.example.sunnzaraa.databinding.FragmentLoginScreenBinding
import com.example.sunnzaraa.databinding.FragmentRegistrationScreenBinding
import com.example.sunnzaraa.ui.login.LoginScreenFragmentDirections
import com.example.sunnzaraa.ui.registration.viewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationScreenFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationScreenBinding

    private val authViewModel by activityViewModels<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleOnClickEvents()
    }

    private fun handleOnClickEvents(){
        binding.nextButton.setOnClickListener {
            val email = binding.emailEdittext.text.toString().trim()
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Toast.makeText(requireContext(), "Enter a valid email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            authViewModel.setEmail(email)

            findNavController().navigate(RegistrationScreenFragmentDirections.actionRegistrationScreenFragmentToCreatePasswordScreenFragment())
        }

        binding.loginText.setOnClickListener {
            findNavController().navigate(RegistrationScreenFragmentDirections.actionRegistrationScreenFragmentToLoginScreenFragment())
        }
    }
}