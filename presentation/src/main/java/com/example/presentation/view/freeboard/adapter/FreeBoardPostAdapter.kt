package com.example.presentation.view.freeboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.data.entity.freeboard.response.AddFreeBoardResponse
import com.example.presentation.R
import android.util.Base64
import com.example.domain.model.freeboard.getpost.DomainGetFreeBoardResponse

class FreeBoardPostAdapter(var freeBoardList: List<DomainGetFreeBoardResponse>, val context: Context)
    : RecyclerView.Adapter<FreeBoardPostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_free_board, parent, false)
        return ViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = freeBoardList[position]._img1
        val imageByteArray = Base64.decode(image, Base64.DEFAULT)
        Glide
            .with(context)
            .asBitmap()
            .load(imageByteArray)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return freeBoardList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.free_board_main_image)
    }
}