package com.example.presentation.view.fragment

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.domain.model.freeboard.getpost.DomainGetFreeBoardResponse
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentFreeBoardBinding
import com.example.presentation.view.freeboard.AddFreeBoardActivity
import com.example.presentation.view.freeboard.adapter.FreeBoardPostAdapter
import com.example.presentation.view.freeboard.adapter.SpacesItemDecoration
import com.example.presentation.view.freeboard.info.PostInfoActivity
import com.example.presentation.view.freeboard.intent.PostImageData
import com.example.presentation.view.login.LoginActivity
import com.example.presentation.viewmodel.NbViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FreeBoardFragment : BaseFragment<FragmentFreeBoardBinding>(R.layout.fragment_free_board), View.OnClickListener {
    private val nbViewModel by activityViewModels<NbViewModel>()
    var postImageData: PostImageData? = null
    val bitmapList = arrayListOf<Bitmap>()

    override fun init() {
        binding.free = this
        viewSetting()
        getUser()
        getPost()

        binding.addPost.bringToFront()
        binding.sangText.bringToFront()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            binding.goLoginText.id -> startActivity(Intent(context, LoginActivity::class.java))
            binding.addPost.id -> {
                val id = arguments?.getInt("id")
                val intent = Intent(context, AddFreeBoardActivity::class.java)
                    .putExtra("createUser", id)
                startActivity(intent)
            }
        }
    }

    private fun getPost() {
        nbViewModel.getPostLogic()
        nbViewModel.getPostApiCallResult.observe(viewLifecycleOwner) {
            val adapter = FreeBoardPostAdapter(it, requireContext())
            binding.freeBoardRecyclerView.adapter = adapter
            binding.freeBoardRecyclerView.layoutManager = GridLayoutManager(context, 3)
            binding.freeBoardRecyclerView.addItemDecoration(SpacesItemDecoration(20))
            itemClick(it ,adapter)
        }
    }

    private fun getUser() {
        val id = arguments?.getInt("id")
        if (id != null) {
            nbViewModel.getUserLogic(id)
            nbViewModel.userInfoApiCallResult.observe(viewLifecycleOwner) {
                if (it != null) {   // 로그인한 유저가 있음
                    Log.d("SUCCESS", "getUser it: $it")
                    binding.goLoginText.visibility = View.GONE
                } else {
                    Log.d("SUCCESS", "guest user")
                }
            }
        } else {
            Log.d("FAIL", "id: $id")
        }
    }

    private fun itemClick(item: List<DomainGetFreeBoardResponse>, adapter: FreeBoardPostAdapter) {
        adapter.itemClick = object : FreeBoardPostAdapter.ItemClick {
            override fun onClick(view: View, data: DomainGetFreeBoardResponse, position: Int) {
                val post = item[position]
                Log.d("SUCCESS", "onClick post: ${post._title}")
                base64ToBitmap(post, bitmapList)

                val intent = Intent(context, PostInfoActivity::class.java)
                    .putExtra("title", post._title)
                    .putExtra("content", post._context)
                    .putExtra("id", post._id)   // 아직 안씀
                    .putExtra("createUser", post._createUser)
                    .putExtra("createDate", post._createDate)
                    .putExtra("correctionDate", post._correctionDate)
                startActivity(intent)
            }
        }
    }

    private fun base64ToBitmap(post: DomainGetFreeBoardResponse, list: ArrayList<Bitmap>) {
        val bitmapImg1 = Base64.decode(post._img1, Base64.DEFAULT)
        val bitmapImg2 = Base64.decode(post._img2, Base64.DEFAULT)
        val bitmapImg3 = Base64.decode(post._img3, Base64.DEFAULT)
        val bitmapImg4 = Base64.decode(post._img4, Base64.DEFAULT)
        val bitmapImg5 = Base64.decode(post._img5, Base64.DEFAULT)

        list.add(BitmapFactory.decodeByteArray(bitmapImg1, 0, bitmapImg1.size))
        list.add(BitmapFactory.decodeByteArray(bitmapImg2, 0, bitmapImg2.size))
        list.add(BitmapFactory.decodeByteArray(bitmapImg3, 0, bitmapImg3.size))
        list.add(BitmapFactory.decodeByteArray(bitmapImg4, 0, bitmapImg4.size))
        list.add(BitmapFactory.decodeByteArray(bitmapImg5, 0, bitmapImg5.size))
        Log.d("SUCCESS", "onClick bitmap list: $list")

        postImageData = PostInfoActivity()
        postImageData?.intentData(list)
        list.clear()
    }

    private fun viewSetting() {
        binding.apply {
            goLoginText.setOnClickListener(this@FreeBoardFragment)
            addPost.setOnClickListener(this@FreeBoardFragment)
        }
    }
}
