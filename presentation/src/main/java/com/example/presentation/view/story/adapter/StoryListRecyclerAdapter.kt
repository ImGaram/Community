package com.example.presentation.view.story.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.story.DomainBaseStoryResponse
import com.example.presentation.databinding.RecyclerItemStoryListBinding

class StoryListRecyclerAdapter(val storyList: List<DomainBaseStoryResponse>): RecyclerView.Adapter<StoryListRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerItemStoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    interface ItemClick {
        fun onClick(view: View, data: DomainBaseStoryResponse, position: Int)
    }
    var itemClick: ItemClick? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(storyList[position])
    }

    override fun getItemCount(): Int {
        return storyList.size
    }

    inner class ViewHolder(val binding: RecyclerItemStoryListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DomainBaseStoryResponse) {
            binding.storyNumber.text = item.id.toString()
            binding.storyTitle.text = item.title
            binding.storyCreatUser.text = item.createUser.toString()
            binding.storyCreateDate.text = item.createDate
        }
    }
}