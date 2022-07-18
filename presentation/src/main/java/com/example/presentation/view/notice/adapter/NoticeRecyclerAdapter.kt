package com.example.presentation.view.notice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.notice.DomainBaseNoticeResponse
import com.example.presentation.databinding.RecyclerItemNoticeBinding

class NoticeRecyclerAdapter(val noticeList: List<DomainBaseNoticeResponse>): RecyclerView.Adapter<NoticeRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerItemNoticeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    interface OnItemClick {
        fun onClick(itemView: View, data: DomainBaseNoticeResponse, position: Int)
    }
    var onItemClick: OnItemClick? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(noticeList[position])
    }

    override fun getItemCount(): Int {
        return noticeList.size
    }

    inner class ViewHolder(val binding: RecyclerItemNoticeBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DomainBaseNoticeResponse) {
            binding.noticeTitle.text = item.title
            binding.noticeNumber.text = item.id.toString()
            binding.noticeCreateDate.text = item.createDate

            val pos = adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                itemView.setOnClickListener {
                    onItemClick?.onClick(itemView, item, pos)
                }
            }
        }
    }
}