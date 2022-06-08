package com.example.presentation.view.freeboard.info

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.R
import com.example.presentation.databinding.ActivityPostInfoBinding
import com.example.presentation.view.freeboard.adapter.FreeBoardPostInfoAdapter
import com.example.presentation.view.freeboard.intent.PostImageData

class PostInfoActivity : AppCompatActivity(), PostImageData {
    private lateinit var binding: ActivityPostInfoBinding
    private val imageList = arrayListOf<Bitmap>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.post = this

        binding.cancelView.bringToFront()
        binding.cancelText.bringToFront()
        viewSetting()

        binding.cancelView.setOnClickListener { finish() }
        binding.postModify.setOnClickListener {
            startActivity(Intent(this, PostModifyActivity::class.java))
        }
    }

    override fun intentData(bitmapArray: ArrayList<Bitmap>) {
        for (i in 0 until bitmapArray.size) {
            imageList.add(bitmapArray[i])
        }
        Log.d("SUCCESS", "intentData: $imageList")
        initRecyclerView(imageList)
    }

    private fun initRecyclerView(item: ArrayList<Bitmap>) {
        Log.d("SUCCESS", "initRecyclerView intentData: $item")
        val recyclerView = findViewById<RecyclerView>(R.id.post_image_recycler_view)
        recyclerView.apply {
            adapter = FreeBoardPostInfoAdapter(item, applicationContext)
            layoutManager = LinearLayoutManager(this@PostInfoActivity, LinearLayoutManager.HORIZONTAL, true)
        }
    }

    private fun viewSetting() {
        binding.postTitleText.text = intent.getStringExtra("title")
        binding.postContentText.text = intent.getStringExtra("content")
        binding.postCreateUser.text = intent.getIntExtra("createUser", 0).toString()
        binding.postCreateDate.text = intent.getStringExtra("createDate")
        binding.correctionDateText.text = "마지막 수정일: ${intent.getStringExtra("correctionDate")}"
    }
}