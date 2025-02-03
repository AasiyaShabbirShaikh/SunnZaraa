package com.example.sunnzaraa.ui.profile

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sunnzaraa.databinding.FragmentEditProfileScreenBinding
import com.example.sunnzaraa.databinding.TakeAPhotoDialogBoxBinding

class EditProfileScreenFragment : Fragment() {

    private lateinit var binding: FragmentEditProfileScreenBinding
    private var dialogbox: Dialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileScreenBinding.inflate(layoutInflater, container,false)

        binding.changeProfilePhotoText.setOnClickListener {
            showTakePhotoDialogBox()
        }
        return binding.root
    }

    private fun showTakePhotoDialogBox(){
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