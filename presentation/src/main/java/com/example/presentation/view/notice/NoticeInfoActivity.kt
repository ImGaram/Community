package com.example.presentation.view.notice

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.data.ApiClient
import com.example.presentation.R
import com.example.presentation.base.BaseActivity
import com.example.presentation.databinding.ActivityNoticeInfoBinding

class NoticeInfoActivity : BaseActivity<ActivityNoticeInfoBinding>(R.layout.activity_notice_info), View.OnClickListener {
    override fun init() {
        binding.noticeInfo = this

        viewSetting()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.noticeInfoCancelView.id -> { finish() }
        }
    }

    private fun viewSetting() {
        binding.noticeInfoCancelView.setOnClickListener(this)
        binding.noticeInfoTitle.text = intent.getStringExtra("title")
        binding.noticeInfoContent.text = intent.getStringExtra("context")
        binding.noticeInfoCreateDate.text = intent.getStringExtra("createDate")

        Glide.with(this).load(ApiClient.BASE_URL + intent.getStringExtra("img")).into(binding.noticeInfoImage)
    }
}