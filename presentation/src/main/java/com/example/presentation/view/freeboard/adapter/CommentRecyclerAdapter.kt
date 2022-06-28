package com.example.presentation.view.freeboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.freeboard.comment.DomainGetCommentResponse
import com.example.presentation.databinding.RecyclerItemCommentBinding

class CommentRecyclerAdapter(private val commentList: List<DomainGetCommentResponse>, private val userId: Int): RecyclerView.Adapter<CommentRecyclerAdapter.ViewHolder>() {
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

    inner class ViewHolder(private val binding: RecyclerItemCommentBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DomainGetCommentResponse) {
            binding.textUserName.text = data.createIdUser.toString()
            binding.textCorrectionDate.text = data.correctionDate
            binding.textCreateDate.text = data.createDate
            binding.textComment.text = data.context

            if (userId == data.createIdUser) {
                binding.commentOption.visibility = View.VISIBLE
            } else {
                binding.commentOption.visibility = View.GONE
            }
        }
    }
}