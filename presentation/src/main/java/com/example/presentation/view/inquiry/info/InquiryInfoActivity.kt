package com.example.presentation.view.inquiry.info

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
import com.example.presentation.databinding.ActivityInquiryInfoBinding
import com.example.presentation.viewmodel.InquiryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InquiryInfoActivity : BaseActivity<ActivityInquiryInfoBinding>(R.layout.activity_inquiry_info), View.OnClickListener {
    private val inquiryViewModel by viewModels<InquiryViewModel>()

    override fun init() {
        binding.inquiryInfo = this

        dataSetting()
        viewSetting()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.inquiryModify.id -> {
                val intent = Intent(this, ModifyInquiryActivity::class.java)
                    .putExtra("postId", intent.getIntExtra("postId", 0))
                    .putExtra("title", intent.getStringExtra("title"))
                    .putExtra("context", intent.getStringExtra("context"))
                    .putExtra("userId", intent.getStringExtra("createUser"))
                startActivity(intent)
            }
            binding.inquiryDelete.id -> {
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
            binding.inquiryCancelView.id -> finish()
        }
    }

    private fun deleteLogic(dialog: AlertDialog?) {
        inquiryViewModel.deleteInquiryLogic(intent.getIntExtra("postId", 0))
        inquiryViewModel.deleteInquiry.observe(this) {
            when (it) {
                204 -> { dialog?.dismiss() }
                404 -> {
                    Log.d("ERROR", "deleteLogic response code: $it")
                    dialog?.dismiss()
                }
                else -> {
                    Log.d("ERROR", "deleteLogic response code: $it")
                    dialog?.dismiss()
                }
            }
        }
    }

    private fun dataSetting() {
        inquiryViewModel.getInquiryLogic(intent.getIntExtra("postId", 0))
        inquiryViewModel.getInquiry.observe(this) {
            if (intent.getIntExtra("userId", 0) != it.createUserId) {
                binding.inquiryBtnLinear.visibility = View.GONE
            }

            binding.inquiryInfoTitle.text = it.title
            binding.inquiryContentText.text = it.context
            binding.inquiryCreateDate.text = it.createDate
            binding.inquiryInfoCreateUser.text = it.createUserId.toString()
        }
    }

    private fun viewSetting() {
        binding.inquiryModify.setOnClickListener(this)
        binding.inquiryDelete.setOnClickListener(this)
        binding.inquiryCancelView.setOnClickListener(this)
    }
}