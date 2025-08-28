package com.example.sunnzaraa.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.room.util.findColumnIndexBySuffix
import com.example.sunnzaraa.R
import com.example.sunnzaraa.databinding.FragmentCreatePasswordScreenBinding
import com.example.sunnzaraa.ui.registration.viewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreatePasswordScreenFragment : Fragment() {

    private lateinit var binding: FragmentCreatePasswordScreenBinding

    private val authViewModel by activityViewModels<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreatePasswordScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNextButtonEvent()
    }

    private fun handleNextButtonEvent(){
        binding.nextButton.setOnClickListener {
            val password = binding.passwordEdittext.text.toString().trim()
            if(!validatePassword(password)){
                Toast.makeText(
                    requireContext(),
                    "Password must be at least 8 characters long and include a letter and a number/@",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
             authViewModel.setPassword(password)
            findNavController().navigate(CreatePasswordScreenFragmentDirections.actionCreatePasswordScreenFragmentToPersonalDetailsScreenFragment())

        }

    }

    private fun validatePassword(password:String) : Boolean{
        val minLenght = password.length >= 8
        val hasLetter = password.any{it.isLetter()}
        val hasNumberOrChar = password.any {it.isDigit() || it == '@'}
        return minLenght && hasLetter && hasNumberOrChar
    }

}

