package com.example.sunnzaraa.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sunnzaraa.R
import com.example.sunnzaraa.databinding.FragmentCreatePasswordScreenBinding

class CreatePasswordScreenFragment : Fragment() {

    private lateinit var binding: FragmentCreatePasswordScreenBinding

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
            val password = binding.passwordEdittext.text.toString()
            if(password != null){
                findNavController().navigate(CreatePasswordScreenFragmentDirections.actionCreatePasswordScreenFragmentToPersonalDetailsScreenFragment())
            }
            else{
                Toast.makeText(requireContext(), "Enter valid password", Toast.LENGTH_SHORT).show()
            }
        }

    }

}