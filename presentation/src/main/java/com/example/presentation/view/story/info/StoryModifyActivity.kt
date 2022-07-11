package com.example.presentation.view.story.info

import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.presentation.R
import com.example.presentation.base.BaseActivity
import com.example.presentation.databinding.ActivityStoryModifyBinding
import com.example.presentation.viewmodel.StoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoryModifyActivity : BaseActivity<ActivityStoryModifyBinding>(R.layout.activity_story_modify), View.OnClickListener {
    private val storyViewModel by viewModels<StoryViewModel>()

    override fun init() {
        binding.modifyStory = this

        viewSetting()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.storyModifyBtn.id -> {
                Log.d("SUCCESS", "onClick postId: ${intent.getIntExtra("postId", 0)}")
                Log.d("SUCCESS", "onClick createUser: ${intent.getIntExtra("createUser", 0)}")

                storyViewModel.modifyStoryLogic(intent.getIntExtra("postId", 0), binding.modifyEditTitleText.text.toString(),
                    binding.modifyEditStoryContent.text.toString(), intent.getIntExtra("createUser", 0))
                storyViewModel.modifyStory.observe(this) {
                    if (it != null) Log.d("SUCCESS", "onClick response: $it")
                    finish()
                }
            }
            binding.storyModifyCancelBtn.id -> { finish() }
        }
    }

    private fun viewSetting() {
        binding.storyModifyBtn.setOnClickListener(this)
        binding.storyModifyCancelBtn.setOnClickListener(this)

        binding.modifyEditTitleText.setText(intent.getStringExtra("title"))
        binding.modifyEditStoryContent.setText(intent.getStringExtra("context"))
    }
}