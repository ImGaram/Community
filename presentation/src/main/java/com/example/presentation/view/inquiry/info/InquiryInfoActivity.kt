package com.example.presentation.view.inquiry.info

import android.view.View
import androidx.activity.viewModels
import com.example.presentation.R
import com.example.presentation.base.BaseActivity
import com.example.presentation.databinding.ActivityInquiryInfoBinding
import com.example.presentation.viewmodel.InquiryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InquiryInfoActivity : BaseActivity<ActivityInquiryInfoBinding>(R.layout.activity_inquiry_info), View.OnClickListener {
    private val inquiryViewModel by viewModels<InquiryViewModel>()

    override fun init() {
        binding.inquiryInfo = this

        dataSetting()
        viewSetting()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.inquiryModify.id -> {

            }
            binding.inquiryDelete.id -> {

            }
            binding.inquiryCancelView.id -> finish()
        }
    }

    private fun dataSetting() {
        inquiryViewModel.getInquiryLogic(intent.getIntExtra("postId", 0))
        inquiryViewModel.getInquiry.observe(this) {
            binding.inquiryInfoTitle.text = it.title
            binding.inquiryContentText.text = it.context
            binding.inquiryCreateDate.text = it.createDate
            binding.inquiryInfoCreateUser.text = it.createUserId.toString()
        }
    }

    private fun viewSetting() {
        binding.inquiryModify.setOnClickListener(this)
        binding.inquiryDelete.setOnClickListener(this)
        binding.inquiryCancelView.setOnClickListener(this)
    }
}