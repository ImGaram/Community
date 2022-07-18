package com.example.presentation.view.fragment

import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.notice.DomainBaseNoticeResponse
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentNoticeBinding
import com.example.presentation.view.notice.adapter.NoticeRecyclerAdapter
import com.example.presentation.viewmodel.NoticeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoticeFragment : BaseFragment<FragmentNoticeBinding>(R.layout.fragment_notice), View.OnClickListener {
    private val noticeViewModel by activityViewModels<NoticeViewModel>()

    override fun init() {
        binding.notice = this

        getNotice()
        viewSetting()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.moreBtn.id -> {

            }
        }
    }

    private fun viewSetting() {
        binding.moreBtn.setOnClickListener(this)
    }

    private fun getNotice() {
        noticeViewModel.getNoticeListLogic()
        noticeViewModel.getNoticeList.observe(viewLifecycleOwner) {
            if (it != null) {
                Log.d("SUCCESS", "getNotice response: $it")
                initRecycler(it)
            } else {
                Log.d("ERROR", "getNotice response: $it")
            }
        }
    }

    private fun initRecycler(list: List<DomainBaseNoticeResponse>) {
        val adapter = NoticeRecyclerAdapter(list)
        binding.noticeRecyclerView.adapter = adapter
        binding.noticeRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}