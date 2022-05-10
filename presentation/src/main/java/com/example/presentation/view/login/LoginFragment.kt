package com.example.presentation.view.login

import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentLoginBinding
import com.example.presentation.viewmodel.NbViewModel

class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login), View.OnClickListener {
    private val nbViewModel by activityViewModels<NbViewModel>()

    override fun init() {
        binding.login = this
        viewSetting()
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            binding.cancelView.id -> {
                Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_mainActivity)
            }
            binding.loginBtn.id -> {
                login(binding.editEmail.text.toString(), binding.editPw.text.toString())
                Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_mainActivity)
            }
            binding.signUpText.id -> {
                Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_signUpFragment)
            }
        }
    }

    private fun login(email: String, password: String) {
        loginLogic(email, password)
        nbViewModel.loginApiCallResult.observe(this) {
            Log.d("SUCCESS", "login it: $it")
        }
    }

    private fun loginLogic(email: String, password: String) {
        nbViewModel.loginLogic(email, password)
    }

    private fun viewSetting() {
        binding.apply {
            cancelView.setOnClickListener(this@LoginFragment)
            loginBtn.setOnClickListener(this@LoginFragment)
            signUpText.setOnClickListener(this@LoginFragment)
        }
    }
}