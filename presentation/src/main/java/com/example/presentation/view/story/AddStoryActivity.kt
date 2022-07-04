package com.example.presentation.view.story

import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.presentation.R
import com.example.presentation.base.BaseActivity
import com.example.presentation.databinding.ActivityAddStoryBinding
import com.example.presentation.viewmodel.StoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddStoryActivity : BaseActivity<ActivityAddStoryBinding>(R.layout.activity_add_story), View.OnClickListener {
    private val viewModel by viewModels<StoryViewModel>()

    override fun init() {
        binding.addStory = this

        viewSetting()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.storyCreateBtn.id -> {
                createStory()
            }
            binding.storyCancelBtn.id -> {

            }
        }
    }

    private fun createStory() {
        viewModel.createStoryLogic(binding.editTitleText.text.toString(), binding.editStoryContent.text.toString(),
            intent.getIntExtra("user_id", 0))
        viewModel.createStory.observe(this) {
            if (it != null) {
                Log.d("SUCCESS", "createStory response: $it")
                finish()
            } else {
                Log.d("FAIL", "createStory response: $it")
            }
        }
    }

    private fun viewSetting() {
        binding.storyCreateBtn.setOnClickListener(this)
        binding.storyCancelBtn.setOnClickListener(this)
    }
}