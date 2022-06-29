package com.example.presentation.view.freeboard.info

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.freeboard.DomainBaseFreeBoardResponse
import com.example.domain.model.freeboard.comment.DomainGetCommentResponse
import com.example.presentation.R
import com.example.presentation.base.BaseActivity
import com.example.presentation.databinding.ActivityPostInfoBinding
import com.example.presentation.view.freeboard.adapter.CommentRecyclerAdapter
import com.example.presentation.view.freeboard.adapter.FreeBoardPostInfoAdapter
import com.example.presentation.viewmodel.NbViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostInfoActivity: BaseActivity<ActivityPostInfoBinding>(R.layout.activity_post_info), View.OnClickListener{
    private val imageList = arrayListOf<Bitmap>()
    private val viewModel by viewModels<NbViewModel>()

    override fun init() {
        binding.post = this

        Log.d("SUCCESS", "init user name: ${intent.getStringExtra("createUser")}")

        viewSetting()
        dataSetting()
        initRecyclerView()
        getComment()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.cancelView.id -> { finish() }
            binding.postModify.id -> {
                val intent = Intent(this, PostModifyActivity::class.java).apply {
                    putExtra("titleToModify", intent.getStringExtra("title"))
                    putExtra("contentToModify", intent.getStringExtra("content"))
                    putExtra("idx", intent.getIntExtra("id", 0))
                }
                startActivity(intent)
            }
            binding.postDelete.id -> {
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
            binding.addComment.id -> {
                viewModel.addCommentLogic(binding.editComment.text.toString(), intent.getIntExtra("userIdIdx", 0),
                    intent.getIntExtra("id", 0))
                viewModel.addCommentApiCallResult.observe(this) {
                    if (it == 201) {
                        Log.d("SUCCESS", "onClick: $it")
                    } else {
                        Log.d("FAIL", "onClick: $it")
                    }
                }
            }
            binding.like.id -> {
                viewModel.suggestLogic(intent.getIntExtra("userIdIdx", 0), intent.getIntExtra("id", 0))
                viewModel.suggestPostApiCallResult.observe(this) {
                    Log.d("SUCCESS", "onClick suggest post result code: $it")
                }
            }
        }
    }

    private fun getComment() {
        viewModel.getCommentLogic(intent.getIntExtra("id", 0))
        viewModel.getCommentApiCallResult.observe(this) {
            initCommentRecycler(it)
        }
    }

    private fun initCommentRecycler(comment: List<DomainGetCommentResponse>) {
        binding.commentRecyclerView.adapter = CommentRecyclerAdapter(comment, intent.getIntExtra("userIdIdx", 0))
        binding.commentRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun initRecyclerView() {
        viewModel.getPostSingleLogic(intent.getIntExtra("id", 0))
        viewModel.getPostSingleApiCallResult.observe(this) {
            Log.d("SUCCESS", "initRecyclerView user id: ${intent.getIntExtra("userIdIdx", 0)}")
            if (intent.getIntExtra("userIdIdx", 0) == it.createUser) {
                binding.btnLinear.visibility = View.VISIBLE
            }
            base64ToBitmap(it, imageList)
            binding.postImageRecyclerView.apply {
                adapter = FreeBoardPostInfoAdapter(imageList, applicationContext)
                layoutManager = LinearLayoutManager(this@PostInfoActivity, LinearLayoutManager.HORIZONTAL, true)
            }
        }
    }

    private fun deleteLogic(dialog: AlertDialog) {
        viewModel.deletePostLogic(intent.getIntExtra("id", 0))
        viewModel.deletePostApiCallResult.observe(this) {
            if (it == 204) {
                dialog.dismiss()
                finish()
            } else {
                dialog.dismiss()
            }
        }
    }

    private fun base64ToBitmap(post: DomainBaseFreeBoardResponse, list: ArrayList<Bitmap>) {
        list.clear()
        val bitmapImg1 = Base64.decode(post.img1, Base64.DEFAULT)
        val bitmapImg2 = Base64.decode(post.img2, Base64.DEFAULT)
        val bitmapImg3 = Base64.decode(post.img3, Base64.DEFAULT)
        val bitmapImg4 = Base64.decode(post.img4, Base64.DEFAULT)
        val bitmapImg5 = Base64.decode(post.img5, Base64.DEFAULT)

        list.add(BitmapFactory.decodeByteArray(bitmapImg1, 0, bitmapImg1.size))
        list.add(BitmapFactory.decodeByteArray(bitmapImg2, 0, bitmapImg2.size))
        list.add(BitmapFactory.decodeByteArray(bitmapImg3, 0, bitmapImg3.size))
        list.add(BitmapFactory.decodeByteArray(bitmapImg4, 0, bitmapImg4.size))
        list.add(BitmapFactory.decodeByteArray(bitmapImg5, 0, bitmapImg5.size))
        Log.d("SUCCESS", "onClick bitmap list: $list")
    }

    private fun viewSetting() {
        binding.cancelView.bringToFront()
        binding.cancelText.bringToFront()
        binding.cancelView.setOnClickListener(this)
        binding.postModify.setOnClickListener(this)
        binding.postDelete.setOnClickListener(this)
        binding.addComment.setOnClickListener(this)
        binding.like.setOnClickListener(this)
    }

    private fun dataSetting() {
        viewModel.getSuggestLogic(intent.getIntExtra("id", 0))
        viewModel.getSuggestPostApiCallResult.observe(this) {
            Log.d("SUCCESS", "getSuggest get suggest post: $it")
            binding.likeCount.text = it.toString()
        }
        binding.postTitleText.text = intent.getStringExtra("title")
        binding.postContentText.text = intent.getStringExtra("content")
        binding.postCreateUser.text = intent.getIntExtra("createUser", 0).toString()
        binding.postCreateDate.text = intent.getStringExtra("createDate")
        binding.correctionDateText.text = "마지막 수정일: ${intent.getStringExtra("correctionDate")}"
    }
}