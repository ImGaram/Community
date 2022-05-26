package com.example.presentation.view.fragment

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentFreeBoardBinding
import com.example.presentation.view.login.LoginActivity
import com.example.presentation.viewmodel.NbViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FreeBoardFragment : BaseFragment<FragmentFreeBoardBinding>(R.layout.fragment_free_board), View.OnClickListener {
    private val nbViewModel by activityViewModels<NbViewModel>()
    override fun init() {
        binding.free = this
        viewSetting()
        getUser()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.goLoginText.id -> startActivity(Intent(context, LoginActivity::class.java))
        }
    }

    private fun getUser() {
        val id = arguments?.getInt("id")
        if (id != null) {
            nbViewModel.getUserLogic(id)
            nbViewModel.userInfoApiCallResult.observe(viewLifecycleOwner) {
                if (it != null) {   // 로그인한 유저가 있음
                    Log.d("SUCCESS", "getUser it: $it")
                    binding.goLoginText.visibility = View.GONE
                } else {
                    Log.d("SUCCESS", "guest user")
                }
            }
        } else {
            Log.d("FAIL", "id: $id")
        }
    }

    private fun viewSetting() {
        binding.apply {
            goLoginText.setOnClickListener(this@FreeBoardFragment)
        }
    }
}