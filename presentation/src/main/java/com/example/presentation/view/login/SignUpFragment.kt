package com.example.presentation.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.presentation.R
import com.example.presentation.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)
        binding.loginText.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_signUpFragment_to_loginFragment)
        }

        binding.signUpBtn.setOnClickListener {
            // 회원가입 로직
            Navigation.findNavController(binding.root).navigate(R.id.action_signUpFragment_to_loginFragment)
        }

        return binding.root
    }
}