package com.example.presentation.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.presentation.R
import com.example.presentation.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        binding.cancelView.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_mainActivity)
        }

        binding.loginBtn.setOnClickListener {
            // 로그인 로직 구현
            Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_mainActivity)
        }

        binding.signUpText.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_signUpFragment)
        }

        return binding.root
    }
}