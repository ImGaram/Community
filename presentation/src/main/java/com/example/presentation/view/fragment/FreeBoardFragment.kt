package com.example.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.presentation.R
import com.example.presentation.databinding.FragmentFreeBoardBinding

class FreeBoardFragment : Fragment() {

    private lateinit var binding: FragmentFreeBoardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFreeBoardBinding.inflate(layoutInflater, container, false)
        binding.goLoginText.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_freeBoardFragment_to_loginActivity)
        }

        return binding.root
    }
}