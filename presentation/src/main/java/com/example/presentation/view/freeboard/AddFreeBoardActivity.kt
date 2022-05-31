package com.example.presentation.view.freeboard

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.presentation.databinding.ActivityAddFreeBoardBinding
import com.example.presentation.view.freeboard.adapter.SelectPhotoAdapter
import com.example.presentation.viewmodel.NbViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.ByteArrayOutputStream
import java.net.URL

@AndroidEntryPoint
class AddFreeBoardActivity : AppCompatActivity() {
    private val nbViewModel by viewModels<NbViewModel>()
    private lateinit var binding: ActivityAddFreeBoardBinding
    var uriList: ArrayList<Uri> = arrayListOf()
    val base64List: ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddFreeBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.add = this

        btnClick()
    }

    private fun btnClick() {
        binding.createBtn.setOnClickListener {
            for (i in 0 until uriList.size) {
                toBase64(i, uriList[i])
                Log.d("SUCCESS", "uriList i: $i")
            }
            nbViewModel.createPostLogic(binding.editTitle.text.toString(), binding.editContent.text.toString(),
                base64List[0], base64List[1], base64List[2], base64List[3], base64List[4], intent.getIntExtra("createUser", 0))
            nbViewModel.addPostApiCallResult.observe(this) {
                Log.d("SUCCESS", "addPostApiCallResult it: $it")
                if (it != null) finish()
            }
        }

        binding.putImage.setOnClickListener {
            gotoGallery()
        }

        binding.cancelBtn.setOnClickListener { finish() }
    }

    private fun gotoGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        startActivityForResult(intent, 2222)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 2222) {
            if (data == null) {
                Log.d("DATA", "이미지 없음")
            } else {
                if (data.clipData == null) {    // 이미지 1개 선택
                    val imageUri: Uri? = data.data
                    uriList.add(imageUri!!)

                    val adapter = SelectPhotoAdapter(uriList, applicationContext)
                    binding.selectPhotoRecyclerView.adapter = adapter
                    binding.selectPhotoRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
                } else {    // 여러 장의 이미지
                    val clipData = data.clipData

                    if (clipData?.itemCount!! > 5) {
                        Log.d("DATA", "사진이 5장 이상 선택됨")
                    } else {
                        for (i in 0 until clipData.itemCount) {
                            val imageUri = clipData.getItemAt(i).uri
                            try {
                                uriList.add(imageUri)
                            } catch (e: Exception) {
                                Log.e("FAILURE", "File select Error", e)
                            }
                        }
                        for (i in clipData.itemCount until 5) {
                            uriList.add(Uri.parse("null"))
                        }
                        Log.d("SUCCESS", "uriList: $uriList")

                        val tempList = arrayListOf<Uri>()
                        for (i in 0 until clipData.itemCount) {
                            tempList.add(clipData.getItemAt(i).uri)
                        }
                        val adapter = SelectPhotoAdapter(tempList, applicationContext)
                        binding.selectPhotoRecyclerView.adapter = adapter
                        binding.selectPhotoRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
                    }
                }
            }

        }
    }

    private fun toBase64(i: Int, uri: Uri) {
        if (uriList[i].toString() != "null") {
            val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            val byteArray: ByteArray = stream.toByteArray()
            val endCoded = Base64.encodeToString(byteArray, Base64.DEFAULT)
            base64List.add(endCoded)
        } else {
            base64List.add("null")
            Log.d("FAIL", "toBase64: wRk")
        }
    }
}