package com.example.sunnzaraa.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sunnzaraa.R
import com.example.sunnzaraa.databinding.FragmentPersonalDetailsScreenBinding
import com.example.sunnzaraa.databinding.ItemSongLayoutBinding
import com.example.sunnzaraa.ui.registration.viewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonalDetailsScreenFragment : Fragment() {

    private lateinit var binding: FragmentPersonalDetailsScreenBinding

    private val authViewModel by activityViewModels<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonalDetailsScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNextButtonEvent()
    }

    private fun handleNextButtonEvent(){
        binding.nextButton.setOnClickListener {
            val name = binding.nameEdittext.text.toString().trim()
            val dob = binding.dobEdittext.text.toString().trim()
            val selectedGenderId = binding.radioGroup.checkedRadioButtonId
            val gender = when(selectedGenderId){
                R.id.male_radio -> "Male"
                R.id.female_radio -> "Female"
                R.id.others_radio -> "Other"
                else-> ""
            }

            if(name.isEmpty()  || dob.isEmpty() || gender.isEmpty()){
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            authViewModel.setPersonalDetails(name, dob, gender)

            findNavController().navigate(PersonalDetailsScreenFragmentDirections.actionPersonalDetailsScreenFragmentToTermsConditionsScreenFragment())
        }
    }
}