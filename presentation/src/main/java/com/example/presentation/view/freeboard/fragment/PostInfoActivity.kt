package com.example.presentation.view.freeboard.fragment

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.presentation.databinding.ActivityPostInfoBinding
import com.example.presentation.view.freeboard.adapter.FreeBoardPostInfoAdapter
import com.example.presentation.view.freeboard.intent.PostImageData
import com.example.presentation.viewmodel.NbViewModel

class PostInfoActivity : AppCompatActivity(), PostImageData {
    private lateinit var binding: ActivityPostInfoBinding
    val imageList = arrayListOf<Bitmap>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.post = this

        binding.cancelView.bringToFront()
        binding.cancelText.bringToFront()
        viewSetting()

        binding.cancelView.setOnClickListener { finish() }
        initRecyclerView()
    }

    override fun intentData(
        bitmapArray: ArrayList<Bitmap>
    ) {
        for (i in 0 until bitmapArray.size) {
            imageList.add(bitmapArray[i])
        }
        Log.d("SUCCESS", "intentData: $bitmapArray")
    }

    private fun initRecyclerView() {
        Log.d("SUCCESS", "onCreate imageList: $imageList")
        binding.postImageRecyclerView.adapter = FreeBoardPostInfoAdapter(imageList, applicationContext)
        binding.postImageRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
    }

    private fun viewSetting() {
        binding.postTitleText.text = intent.getStringExtra("title")
        binding.postContentText.text = intent.getStringExtra("content")
        binding.postCreateUser.text = intent.getIntExtra("createUser", 0).toString()
        binding.postCreateDate.text = intent.getStringExtra("createDate")
        binding.correctionDateText.text = "마지막 수정일: ${intent.getStringExtra("correctionDate")}"
    }
}