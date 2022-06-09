package com.example.presentation.view.freeboard.adapter

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.presentation.R

class FreeBoardPostInfoAdapter(private var imageList: ArrayList<Bitmap>, val context: Context): RecyclerView.Adapter<FreeBoardPostInfoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_post_info, parent, false)
        return ViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imagePos = imageList[position]
        if (imagePos.toString() == "null") {
            Log.d("SUCCESS", "bind image item $imagePos: is null")
        } else {
            Glide
                .with(context)
                .asBitmap()
                .load(imagePos)
                .into(holder.image)
        }
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.post_info_image)
    }
}