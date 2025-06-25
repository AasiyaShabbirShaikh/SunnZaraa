package com.example.sunnzaraa.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.sunnzaraa.R
import com.example.sunnzaraa.databinding.FragmentLoginScreenBinding

class LoginScreenFragment : Fragment() {

    private lateinit var binding : FragmentLoginScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            val email = binding.emailEdittext.text.toString()
            val password = binding.passwordEdittext.text.toString()

            if(email == "a" && password == "s"){
                findNavController().navigate(LoginScreenFragmentDirections.actionLoginScreenFragmmentToHomeGraph())
            }
            else{
                Toast.makeText(requireContext(), "Invalid credentials, Please try again !", Toast.LENGTH_SHORT).show()
            }
        }

        handleOnClickEvents()
    }

    private fun handleOnClickEvents(){

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

    }
}