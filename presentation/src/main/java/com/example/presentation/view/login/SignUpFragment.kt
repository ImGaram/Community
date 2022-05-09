package com.example.presentation.view.login

import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentSignUpBinding
import com.example.presentation.viewmodel.NbViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : BaseFragment<FragmentSignUpBinding>(R.layout.fragment_sign_up), View.OnClickListener {
    private val nbViewModel by activityViewModels<NbViewModel>()

    override fun init() {
        binding.signIn = this
        viewSetting()
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            binding.loginText.id -> {
                Navigation.findNavController(binding.root).navigate(R.id.action_signUpFragment_to_loginFragment)
            }
            binding.signUpBtn.id -> {
                createUser()
                Navigation.findNavController(binding.root).navigate(R.id.action_signUpFragment_to_loginFragment)
            }
        }
    }

    private fun createUser() {
        val email = binding.editEmail.text.toString()
        val name = binding.editName.text.toString()
        val password = binding.editPw.text.toString()
        signInLogic(email, name, password)
        nbViewModel.apiCallResult.observe(viewLifecycleOwner) {
            Log.d("SUCCESS", "createUser it: $it")
        }
    }

    private fun signInLogic(email: String, name: String, password: String) {
        nbViewModel.signInLogic(name, email, password)
    }

    private fun viewSetting() {
        binding.apply {
            loginText.setOnClickListener(this@SignUpFragment)
            signUpBtn.setOnClickListener(this@SignUpFragment)
        }
    }
}