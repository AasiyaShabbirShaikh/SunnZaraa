package com.example.sunnzaraa.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.sunnzaraa.R
import com.example.sunnzaraa.databinding.FragmentHelpFaqScreenBinding

class HelpFaqScreenFragment : Fragment() {

    private lateinit var binding: FragmentHelpFaqScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHelpFaqScreenBinding.inflate(inflater, container, false)

        setArrowClick()
        return binding.root
    }

    private fun setArrowClick(){
        binding.que1Arrow.setOnClickListener {
            setUpArrowAnswerTextUI(binding.ans1Text, binding.que1Arrow)
        }
        binding.que2Arrow.setOnClickListener {
            setUpArrowAnswerTextUI(binding.ans2Text, binding.que2Arrow)
        }
        binding.que3Arrow.setOnClickListener {
            setUpArrowAnswerTextUI(binding.ans3Text, binding.que3Arrow)
        }
        binding.que4Arrow.setOnClickListener {
            setUpArrowAnswerTextUI(binding.ans4Text, binding.que4Arrow)
        }
        binding.que5Arrow.setOnClickListener {
            setUpArrowAnswerTextUI(binding.ans5Text, binding.que5Arrow)
        }
        binding.que6Arrow.setOnClickListener {
            setUpArrowAnswerTextUI(binding.ans6Text, binding.que6Arrow)
        }
        binding.que7Arrow.setOnClickListener {
            setUpArrowAnswerTextUI(binding.ans7Text, binding.que7Arrow)
        }
    }

    private fun setUpArrowAnswerTextUI(answerText: TextView, arrowImage: ImageView){
        if(answerText.visibility == View.GONE){
            answerText.isVisible = true
            arrowImage.setImageResource(R.drawable.ic_drop_up_arrow_icon)
        }
        else{
            answerText.isVisible = false
            arrowImage.setImageResource(R.drawable.ic_drop_down_arrow_icon)
        }
    }

}