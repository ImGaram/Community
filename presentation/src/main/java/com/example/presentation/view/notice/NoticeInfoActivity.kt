package com.example.presentation.view.notice

import android.view.View
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

        // TODO:: image 불러오기
    }
}