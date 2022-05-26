package com.example.presentation.view.user

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.data.ApiClient
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentUserInfoBinding
import com.example.presentation.view.MainActivity
import com.example.presentation.view.login.LoginActivity
import com.example.presentation.viewmodel.NbViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserInfoFragment : BaseFragment<FragmentUserInfoBinding>(R.layout.fragment_user_info), View.OnClickListener {
    private val nbViewModel by activityViewModels<NbViewModel>()

    override fun init() {
        binding.data = this
        setUserInfo()
        viewSetting()
    }

    private fun setUserInfo() {
        binding.name.text = arguments?.getString("name")
        binding.email.text = arguments?.getString("email")
        binding.password.text = arguments?.getString("password")
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.usernameRevision.id -> {
                binding.revisionLinear.visibility = View.VISIBLE
                binding.revisionText.text = "유저 이름 수정"
                binding.editRevision.hint = "새 유저 이름을 입력하세요."
            }
            binding.emailRevision.id -> {
                binding.revisionLinear.visibility = View.VISIBLE
                binding.revisionText.text = "이메일 수정"
                binding.editRevision.hint = "새 이메일을 입력하세요."
            }
            binding.passwordRevision.id -> {
                binding.revisionLinear.visibility = View.VISIBLE
                binding.revisionText.text = "비밀번호 수정"
                binding.editRevision.hint = "새 비밀번호를 입력하세요."
            }
            binding.saveRevision1.id -> {
                if (binding.editRevision.text.isNotEmpty()) {
                    when(binding.editRevision.hint) {
                        "새 유저 이름을 입력하세요." -> {
                            binding.name.text = binding.editRevision.text.toString()
                            binding.saveRevision2.visibility = View.VISIBLE
                        }
                        "새 이메일을 입력하세요." -> {
                            binding.email.text = binding.editRevision.text.toString()
                            binding.saveRevision2.visibility = View.VISIBLE
                        }
                        "새 비밀번호를 입력하세요." -> {
                            binding.password.text = binding.editRevision.text.toString()
                            binding.saveRevision2.visibility = View.VISIBLE
                        }
                    }
                } else {
                    Log.d("FAIL", "edit text is empty...")
                }
            }
            binding.saveRevision2.id -> {
                val id = arguments?.getInt("id")
                nbViewModel.revisionLogic(id!!, binding.name.text.toString(), binding.email.text.toString(), binding.password.text.toString())
                nbViewModel.userRevisionApiCallResult.observe(viewLifecycleOwner) {
                    Log.d("SUCCESS", "revisionLogic it: $it")
                }
                val intent = Intent(activity, MainActivity::class.java)
                    .putExtra("dataId", binding.name.toString())
                startActivity(intent)
            }
            binding.deleteBtn.id -> {
                val id = arguments?.getInt("id")
                nbViewModel.deleteUserLogic(id!!)
                nbViewModel.deleteUserApiCallResult.observe(viewLifecycleOwner) {
                    if (ApiClient.resultCode == 204) {
                        Log.d("SUCCESS", "성공적으로 삭제함 status: ${ApiClient.resultCode}")
                        startActivity(Intent(activity, MainActivity::class.java))
                    } else {
                        Log.d("FAIL", "삭제 실패함 status: ${ApiClient.resultCode}")
                    }
                }
            }
            binding.logoutBtn.id -> startActivity(Intent(activity, LoginActivity::class.java))
        }
    }

    private fun viewSetting() {
        binding.apply {
            usernameRevision.setOnClickListener(this@UserInfoFragment)
            emailRevision.setOnClickListener(this@UserInfoFragment)
            passwordRevision.setOnClickListener(this@UserInfoFragment)
            saveRevision1.setOnClickListener(this@UserInfoFragment)
            saveRevision2.setOnClickListener(this@UserInfoFragment)
            logoutBtn.setOnClickListener(this@UserInfoFragment)
            deleteBtn.setOnClickListener(this@UserInfoFragment)
        }
    }
}