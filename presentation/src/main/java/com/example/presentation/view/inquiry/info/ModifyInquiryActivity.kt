package com.example.presentation.view.inquiry.info

import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.presentation.R
import com.example.presentation.base.BaseActivity
import com.example.presentation.databinding.ActivityModifyInquiryBinding
import com.example.presentation.viewmodel.InquiryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ModifyInquiryActivity : BaseActivity<ActivityModifyInquiryBinding>(R.layout.activity_modify_inquiry), View.OnClickListener{
    val inquiryViewModel by viewModels<InquiryViewModel>()

    override fun init() {
        binding.modifyInquiry = this

        viewSetting()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.inquiryModifyBtn.id -> {
                inquiryViewModel.modifyInquiryLogic(intent.getIntExtra("postId", 0), binding.modifyInquiryEditTitleText.text.toString(),
                    binding.modifyEditInquiryContent.text.toString(), intent.getIntExtra("userId", 0))
                inquiryViewModel.modifyInquiry.observe(this) {
                    if (it != null) {
                        Log.d("SUCCESS", "onClick response: $it")
                        finish()
                    }
                    else Log.d("ERROR", "onClick response: $it")
                }
            }
            binding.inquiryModifyCancelBtn.id -> finish()
        }
    }

    private fun viewSetting() {
        binding.modifyInquiryEditTitleText.setText(intent.getStringExtra("title"))
        binding.modifyEditInquiryContent.setText(intent.getStringExtra("context"))

        binding.inquiryModifyBtn.setOnClickListener(this)
        binding.inquiryModifyCancelBtn.setOnClickListener(this)
    }
}