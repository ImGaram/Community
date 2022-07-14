package com.example.presentation.view.inquiry.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.inquiry.DomainBaseInquiryResponse
import com.example.presentation.databinding.RecyclerItemStoryListBinding

class InquiryListRecyclerAdapter(val inquiryList: List<DomainBaseInquiryResponse>): RecyclerView.Adapter<InquiryListRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerItemStoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(inquiryList[position])
    }

    override fun getItemCount(): Int {
        return inquiryList.size
    }

    inner class ViewHolder(val binding: RecyclerItemStoryListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DomainBaseInquiryResponse) {
            binding.storyNumber.text = item.id.toString()
            binding.storyCreateDate.text = item.createDate
            binding.storyTitle.text = item.title
            binding.storyCreateDate.text = item.createDate
        }
    }
}