package com.example.sunnzaraa.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sunnzaraa.R
import com.example.sunnzaraa.databinding.FragmentLoginScreenBinding
import com.example.sunnzaraa.ui.registration.viewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginScreenFragment : Fragment() {

    private lateinit var binding : FragmentLoginScreenBinding
    private val authViewModel by activityViewModels<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleOnClickEvents()
    }

    private fun handleOnClickEvents(){
        binding.loginButton.setOnClickListener {
            val email = binding.emailEdittext.text.toString().trim()
            val password = binding.passwordEdittext.text.toString().trim()

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            authViewModel.login(email, password)
        }

        observeLoginresult()

        binding.forgotPasswordText.setOnClickListener {

        }

        binding.signupText.setOnClickListener {
            findNavController().navigate(LoginScreenFragmentDirections.actionLoginScreenFragmentToRegistrationScreenFragment())
        }

        binding.emailEdittext.setOnFocusChangeListener { _, view ->
            if (view) {
                binding.emailEdittext.hint = ""
            } else {
                binding.emailEdittext.hint = getString(R.string.email_id_hint)
            }
        }

        binding.passwordEdittext.setOnFocusChangeListener { _, view ->
            if (view) {
                binding.passwordEdittext.hint = ""
            } else {
                binding.passwordEdittext.hint = getString(R.string.password_hint)
            }
        }

        binding.rememberMeSwitch.setOnClickListener {

        }

    }

    private fun observeLoginresult(){
        authViewModel.loginResult.observe(viewLifecycleOwner){result ->
            result.onSuccess{
                findNavController().navigate(LoginScreenFragmentDirections.actionLoginScreenFragmmentToHomeGraph())
            }

            result.onFailure {
                Toast.makeText(requireContext(), "Invalid Credentials!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}