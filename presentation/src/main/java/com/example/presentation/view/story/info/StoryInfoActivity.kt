package com.example.presentation.view.story.info

import android.view.View
import androidx.activity.viewModels
import com.example.presentation.R
import com.example.presentation.base.BaseActivity
import com.example.presentation.databinding.ActivityStoryInfoBinding
import com.example.presentation.viewmodel.StoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoryInfoActivity : BaseActivity<ActivityStoryInfoBinding>(R.layout.activity_story_info), View.OnClickListener {
    private val viewModel by viewModels<StoryViewModel>()

    override fun init() {
        binding.storyInfo = this
        binding.storyCancelView.bringToFront()
        binding.storyCancelText.bringToFront()

        dataSetting()
        viewSetting()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.storyModify.id -> {

            }
            binding.storyDelete.id -> {

            }
            binding.storyCancelView.id -> { finish() }
        }
    }

    private fun viewSetting() {
        binding.storyDelete.setOnClickListener(this)
        binding.storyModify.setOnClickListener(this)
        binding.storyCancelView.setOnClickListener(this)
    }

    private fun dataSetting() {
        viewModel.getSingleStoryLogic(intent.getIntExtra("postId", 0))
        viewModel.getSingleStory.observe(this) {
            if (intent.getIntExtra("createUser", 0) == it.createUser) {
                binding.storyBtnLinear.visibility = View.VISIBLE
            } else {
                binding.storyBtnLinear.visibility = View.GONE
            }

            binding.storyInfoTitle.text = it.title
            binding.storyInfoCreateUser.text = it.createUser.toString()
            binding.storyContentText.text = it.context
            binding.storyCreateDate.text = it.createDate
        }
    }
}