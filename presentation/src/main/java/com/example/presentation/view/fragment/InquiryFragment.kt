package com.example.presentation.view.fragment

import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentInquiryBinding
import com.example.presentation.viewmodel.NbViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InquiryFragment : BaseFragment<FragmentInquiryBinding>(R.layout.fragment_inquiry), View.OnClickListener {
    private val viewModel by activityViewModels<NbViewModel>()

    override fun init() {
        viewSetting()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.view2.id -> {
                Log.d("SUCCESS", "onClick inquiry: ${arguments?.getInt("id")}")
            }
            binding.moreBtn.id -> {
                binding.inquiryRecyclerView.overScrollMode = View.OVER_SCROLL_ALWAYS
            }
        }
    }

    private fun viewSetting() {
        binding.apply {
            view2.setOnClickListener(this@InquiryFragment)
            moreBtn.setOnClickListener(this@InquiryFragment)
        }
    }
}