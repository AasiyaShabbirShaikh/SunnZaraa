package com.example.sunnzaraa.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sunnzaraa.R
import com.example.sunnzaraa.databinding.FragmentLoginScreenBinding
import com.example.sunnzaraa.databinding.FragmentRegistrationScreenBinding
import com.example.sunnzaraa.ui.login.LoginScreenFragmentDirections

class RegistrationScreenFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationScreenBinding

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
            val email = binding.emailEdittext.text.toString()
            if(email != null){
                findNavController().navigate(RegistrationScreenFragmentDirections.actionRegistrationScreenFragmentToCreatePasswordScreenFragment())
            }
            else{
                Toast.makeText(requireContext(), "Enter valid Email Id", Toast.LENGTH_SHORT).show()
            }
        }

        binding.loginText.setOnClickListener {
            findNavController().navigate(RegistrationScreenFragmentDirections.actionRegistrationScreenFragmentToLoginScreenFragment())
        }
    }
}