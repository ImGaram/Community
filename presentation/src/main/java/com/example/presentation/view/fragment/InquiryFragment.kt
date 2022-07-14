package com.example.presentation.view.fragment

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentInquiryBinding
import com.example.presentation.view.inquiry.AddInquiryActivity
import com.example.presentation.view.inquiry.adapter.InquiryListRecyclerAdapter
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
            } else {
                Log.d("FAIL", "initRecycler response: $it")
            }
        }
    }

    private fun viewSetting() {
        binding.apply {
            createInquiry.setOnClickListener(this@InquiryFragment)
            moreBtn.setOnClickListener(this@InquiryFragment)
        }
    }
}