package com.example.presentation.view.freeboard.info

import android.content.Intent
import android.graphics.Bitmap
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.presentation.R
import com.example.presentation.base.BaseActivity
import com.example.presentation.databinding.ActivityPostInfoBinding
import com.example.presentation.view.freeboard.adapter.FreeBoardPostInfoAdapter
import com.example.presentation.viewmodel.NbViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostInfoActivity: BaseActivity<ActivityPostInfoBinding>(R.layout.activity_post_info), View.OnClickListener{
    private val imageList = arrayListOf<Bitmap>()
    private val viewModel by viewModels<NbViewModel>()

    override fun init() {
        binding.post = this

        viewSetting()
        dataSetting()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.cancelView.id -> { finish() }
            binding.postModify.id -> {
                startActivity(Intent(this, PostModifyActivity::class.java))
            }
        }
    }

    private fun initRecyclerView(item: ArrayList<Bitmap>) {
        Log.d("SUCCESS", "initRecyclerView intentData: $item")
        binding.postImageRecyclerView.apply {
            adapter = FreeBoardPostInfoAdapter(item, applicationContext)
            layoutManager = LinearLayoutManager(this@PostInfoActivity, LinearLayoutManager.HORIZONTAL, true)
        }
    }

    private fun viewSetting() {
        binding.cancelView.bringToFront()
        binding.cancelText.bringToFront()
        binding.cancelView.setOnClickListener(this)
        binding.postModify.setOnClickListener(this)
    }

    private fun dataSetting() {
        Log.d("SUCCESS", "dataSetting pos: ${intent.getIntExtra("id", 0)}")
        binding.postTitleText.text = intent.getStringExtra("title")
        binding.postContentText.text = intent.getStringExtra("content")
        binding.postCreateUser.text = intent.getIntExtra("createUser", 0).toString()
        binding.postCreateDate.text = intent.getStringExtra("createDate")
        binding.correctionDateText.text = "마지막 수정일: ${intent.getStringExtra("correctionDate")}"
    }
}