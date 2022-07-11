package com.example.presentation.view.story.info

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatButton
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
                val intent = Intent(this, StoryModifyActivity::class.java)
                    .putExtra("createUser", intent.getIntExtra("createUser", 0))
                    .putExtra("title", intent.getStringExtra("title"))
                    .putExtra("context", intent.getStringExtra("context"))
                    .putExtra("postId", intent.getIntExtra("postId", 0))
                startActivity(intent)
            }
            binding.storyDelete.id -> {
                val delDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog_delete, null)
                val dialogBuilder = AlertDialog.Builder(this)
                    .setView(delDialogView)
                val dialog = dialogBuilder.show()
                val mDialog = Dialog(this)
                mDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

                delDialogView.findViewById<AppCompatButton>(R.id.delete_ok_btn).setOnClickListener {
                    deleteLogic(dialog)
                }
                delDialogView.findViewById<AppCompatButton>(R.id.delete_cancel_btn).setOnClickListener { dialog.dismiss() }
            }
            binding.storyCancelView.id -> { finish() }
        }
    }

    private fun deleteLogic(dialog: AlertDialog) {
        viewModel.deleteStoryLogic(intent.getIntExtra("postId", 0))
        viewModel.deleteStory.observe(this) {
            when (it) {
                204 -> {
                    dialog.dismiss()
                    finish()
                }
                404 -> {
                    Log.d("ERROR", "deleteLogic code: $it")
                    dialog.dismiss()
                }
                else -> {
                    Log.d("ERROR", "deleteLogic code: $it")
                    dialog.dismiss()
                }
            }
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
            if (intent.getIntExtra("userId", 0) == it.createUser) {
                binding.storyBtnLinear.visibility = View.VISIBLE
            }
            binding.storyInfoTitle.text = it.title
            binding.storyInfoCreateUser.text = it.createUser.toString()
            binding.storyContentText.text = it.context
            binding.storyCreateDate.text = it.createDate
        }
    }
}