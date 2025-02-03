package com.example.sunnzaraa.ui.profile

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sunnzaraa.R
import com.example.sunnzaraa.databinding.FragmentProfileScreenBinding
import com.example.sunnzaraa.databinding.TakeAPhotoDialogBoxBinding

class ProfileScreenFragment : Fragment() {

    private lateinit var binding: FragmentProfileScreenBinding

    private var dialogbox: Dialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentProfileScreenBinding.inflate(layoutInflater, container, false)

        binding.apply {
            editText.setOnClickListener {
                findNavController().navigate(R.id.editProfileScreenFragment)
            }

            favouritesLayout.setOnClickListener {
                findNavController().navigate(R.id.favouritesScreenFragment)
            }

            libraryLayout.setOnClickListener {
                findNavController().navigate(R.id.libraryScreenFragment)
            }

            imgLayout.setOnClickListener {
                showPhotoDialogBox()
            }
        }

        return binding.root
    }

    private fun showPhotoDialogBox(){
        val dialogBinding = TakeAPhotoDialogBoxBinding.inflate(layoutInflater)
        dialogbox = Dialog(requireContext())

        dialogbox?.apply {
            setContentView(dialogBinding.root)
            window?.setBackgroundDrawableResource(android.R.color.transparent)
            window?.setLayout(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )
            setCancelable(true)
        }
        dialogbox?.show()

    }

}