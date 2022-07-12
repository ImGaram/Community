package com.example.presentation.view.story.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.story.DomainBaseCommentResponse
import com.example.presentation.databinding.RecyclerItemCommentBinding

class CommentListRecyclerAdapter(val commentList: List<DomainBaseCommentResponse>): RecyclerView.Adapter<CommentListRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(commentList[position])
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    inner class ViewHolder(val binding: RecyclerItemCommentBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DomainBaseCommentResponse) {
            binding.textComment.text = item.context
            binding.textCreateDate.text = item.createDate
            binding.textCorrectionDate.text = item.correctionDate
            binding.textUserName.text = item.createIdUserSt.toString()
        }
    }
}