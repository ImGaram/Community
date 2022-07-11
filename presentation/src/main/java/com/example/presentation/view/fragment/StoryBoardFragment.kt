package com.example.presentation.view.fragment

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.story.DomainBaseStoryResponse
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentStoryBoardBinding
import com.example.presentation.view.story.AddStoryActivity
import com.example.presentation.view.story.adapter.StoryListRecyclerAdapter
import com.example.presentation.view.story.info.StoryInfoActivity
import com.example.presentation.viewmodel.StoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoryBoardFragment : BaseFragment<FragmentStoryBoardBinding>(R.layout.fragment_story_board), View.OnClickListener {
    private val nbViewModel by activityViewModels<StoryViewModel>()

    override fun init() {
        binding.storyBoard = this

        getStory()
        viewSetting()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.addStoryView.id -> {
                val intent = Intent(context, AddStoryActivity::class.java)
                    .putExtra("user_id", arguments?.getInt("id"))
                startActivity(intent)
            }
            binding.moreBtn.id -> {

            }
        }
    }

    private fun getStory() {
        nbViewModel.getStoryLogic()
        nbViewModel.getStory.observe(viewLifecycleOwner) {
            if (it != null) {
                Log.d("SUCCESS", "getStory response: $it")
                val adapter = StoryListRecyclerAdapter(it)
                binding.storyListRecyclerView.setHasFixedSize(true)
                binding.storyListRecyclerView.adapter = adapter
                binding.storyListRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                onItemClick(it, adapter)
            } else {
                Log.d("FAIL", "getStory response: $it")
            }
        }
    }

    private fun viewSetting() {
        binding.addStoryView.setOnClickListener(this)
        binding.moreBtn.setOnClickListener(this)

        if (arguments?.getInt("id") == 0) {
            binding.addStoryView.visibility = View.GONE
        }
    }

    private fun onItemClick(list: List<DomainBaseStoryResponse>, adapter: StoryListRecyclerAdapter) {
        adapter.itemClick = object :StoryListRecyclerAdapter.ItemClick {
            override fun onClick(view: View, data: DomainBaseStoryResponse, position: Int) {
                val story = list[position]

                Log.d("SUCCESS", "onClick post: $story")
                val intent = Intent(context, StoryInfoActivity::class.java)
                    .putExtra("userId", arguments?.getInt("id"))
                    .putExtra("postId", story.id)
                    .putExtra("title", story.title)
                    .putExtra("context", story.context)
                    .putExtra("createUser", story.createUser)
                    .putExtra("createDate", story.createDate)
                startActivity(intent)
            }
        }
    }
}