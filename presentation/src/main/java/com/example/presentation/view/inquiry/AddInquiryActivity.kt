package com.example.presentation.view.inquiry

import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.presentation.R
import com.example.presentation.base.BaseActivity
import com.example.presentation.databinding.ActivityAddInquiryBinding
import com.example.presentation.viewmodel.InquiryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddInquiryActivity : BaseActivity<ActivityAddInquiryBinding>(R.layout.activity_add_inquiry), View.OnClickListener {
    private val viewModel by viewModels<InquiryViewModel>()

    override fun init() {
        binding.addInquiry = this

        viewSetting()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.inquiryCreateBtn.id -> {
                viewModel.createInquiryLogic(binding.inquiryEditTitleText.text.toString(), binding.editInquiryContent.text.toString(),
                    intent.getIntExtra("userId", 0))
                viewModel.createInquiry.observe(this) {
                    if (it != null) {
                        finish()
                    } else {
                        Log.d("FAIL", "onClick response: $it")
                    }
                }
            }
            binding.inquiryCancelBtn.id -> { finish() }
        }
    }

    private fun viewSetting() {
        binding.inquiryCreateBtn.setOnClickListener(this)
        binding.inquiryCancelBtn.setOnClickListener(this)
    }
}