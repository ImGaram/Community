package com.example.presentation.view.fragment

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.inquiry.DomainBaseInquiryResponse
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentInquiryBinding
import com.example.presentation.view.inquiry.AddInquiryActivity
import com.example.presentation.view.inquiry.adapter.InquiryListRecyclerAdapter
import com.example.presentation.view.inquiry.info.InquiryInfoActivity
import com.example.presentation.viewmodel.InquiryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InquiryFragment : BaseFragment<FragmentInquiryBinding>(R.layout.fragment_inquiry), View.OnClickListener {
    private val viewModel by activityViewModels<InquiryViewModel>()

    override fun init() {
        binding.inquiry = this

        initRecycler()
        viewSetting()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.createInquiry.id -> {
                Log.d("SUCCESS", "onClick inquiry: ${arguments?.getInt("id")}")
                val intent = Intent(context, AddInquiryActivity::class.java)
                    .putExtra("userId", arguments?.getInt("id"))
                startActivity(intent)
            }
            binding.moreBtn.id -> {
                binding.inquiryRecyclerView.overScrollMode = View.OVER_SCROLL_ALWAYS
            }
        }
    }

    private fun initRecycler() {
        viewModel.getInquiryListLogic()
        viewModel.getInquiryList.observe(viewLifecycleOwner) {
            if (it != null) {
                val adapter = InquiryListRecyclerAdapter(it)
                binding.inquiryRecyclerView.setHasFixedSize(true)
                binding.inquiryRecyclerView.adapter = adapter
                binding.inquiryRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                onItemClick(adapter, it)
            } else {
                Log.d("FAIL", "initRecycler response: $it")
            }
        }
    }

    private fun onItemClick(adapter: InquiryListRecyclerAdapter, list: List<DomainBaseInquiryResponse>) {
        adapter.onItemClick = object :InquiryListRecyclerAdapter.OnItemClick {
            override fun onClick(view: View, data: DomainBaseInquiryResponse, position: Int) {
                val intent = Intent(context, InquiryInfoActivity::class.java)
                    .putExtra("userId", arguments?.getInt("id"))
                    .putExtra("postId", list[position].id)
                    .putExtra("title", list[position].title)
                    .putExtra("context", list[position].context)
                    .putExtra("createUser", list[position].createUserId)
                startActivity(intent)
            }
        }
    }

    private fun viewSetting() {
        if (arguments?.getInt("id") == 0) binding.createInquiry.visibility = View.GONE

        binding.apply {
            createInquiry.setOnClickListener(this@InquiryFragment)
            moreBtn.setOnClickListener(this@InquiryFragment)
        }
    }
}