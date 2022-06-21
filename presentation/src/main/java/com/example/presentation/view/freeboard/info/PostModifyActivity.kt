package com.example.presentation.view.freeboard.info

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.freeboard.DomainBaseFreeBoardResponse
import com.example.presentation.R
import com.example.presentation.base.BaseActivity
import com.example.presentation.databinding.ActivityPostModifyBinding
import com.example.presentation.view.freeboard.adapter.FreeBoardPostInfoAdapter
import com.example.presentation.viewmodel.NbViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostModifyActivity :BaseActivity<ActivityPostModifyBinding>(R.layout.activity_post_modify), View.OnClickListener {
    private val viewModel by viewModels<NbViewModel>()
    private val list = arrayListOf<Bitmap>()

    override fun init() {
        binding.modifyPost = this

        getPost()
        viewSetting()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.modifyBtn.id -> {
                viewModel.getPostSingleLogic(intent.getIntExtra("idx", 0))
                viewModel.getPostSingleApiCallResult.observe(this) {
                    modifyPost(it)
                    finish()
                }
            }
            binding.modifyCancelBtn.id -> { finish() }
        }
    }

    private fun getPost() {
        viewModel.getPostSingleLogic(intent.getIntExtra("idx", 0))
        viewModel.getPostSingleApiCallResult.observe(this) {
            binding.modifyTitle.setText(it.title)
            binding.modifyContent.setText(it.context)

            base64ToBitmap(it, list)
            initRecyclerView(list)
        }
    }

    private fun modifyPost(it: DomainBaseFreeBoardResponse) {
        viewModel.modifyPostLogic(binding.modifyTitle.text.toString(), binding.modifyContent.text.toString(),
            it.img1, it.img2, it.img3, it.img4, it.img5,
            it.createUser, intent.getIntExtra("idx", 0))
        viewModel.modifyPostApiCallResult.observe(this) { data ->
            Log.d("SUCCESS", "modifyPost: $data")
        }
    }

    private fun initRecyclerView(data: ArrayList<Bitmap>) {
        binding.modifyPostRecyclerView.adapter = FreeBoardPostInfoAdapter(data, applicationContext)
        binding.modifyPostRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
    }

    private fun base64ToBitmap(item: DomainBaseFreeBoardResponse, array: ArrayList<Bitmap>) {
        array.clear()
        val bitmapImg1 = Base64.decode(item.img1, Base64.DEFAULT)
        val bitmapImg2 = Base64.decode(item.img2, Base64.DEFAULT)
        val bitmapImg3 = Base64.decode(item.img3, Base64.DEFAULT)
        val bitmapImg4 = Base64.decode(item.img4, Base64.DEFAULT)
        val bitmapImg5 = Base64.decode(item.img5, Base64.DEFAULT)

        array.add(BitmapFactory.decodeByteArray(bitmapImg1, 0, bitmapImg1.size))
        array.add(BitmapFactory.decodeByteArray(bitmapImg2, 0, bitmapImg2.size))
        array.add(BitmapFactory.decodeByteArray(bitmapImg3, 0, bitmapImg3.size))
        array.add(BitmapFactory.decodeByteArray(bitmapImg4, 0, bitmapImg4.size))
        array.add(BitmapFactory.decodeByteArray(bitmapImg5, 0, bitmapImg5.size))
    }

    private fun viewSetting() {
        binding.modifyCancelBtn.setOnClickListener(this)
        binding.modifyBtn.setOnClickListener(this)
    }
}