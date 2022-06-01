package com.example.presentation.view.freeboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.presentation.R
import android.util.Base64
import com.example.domain.model.freeboard.getpost.DomainGetFreeBoardResponse

class FreeBoardPostAdapter(var freeBoardList: List<DomainGetFreeBoardResponse>, val context: Context)
    : RecyclerView.Adapter<FreeBoardPostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_free_board, parent, false)
        return ViewHolder(layoutInflater)
    }

    interface ItemClick {
        fun onClick(view: View, data: DomainGetFreeBoardResponse, position: Int)
    }
    var itemClick: ItemClick? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(freeBoardList[position])
    }

    override fun getItemCount(): Int {
        return freeBoardList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.free_board_main_image)

        fun bind(item: DomainGetFreeBoardResponse) {
            val imageByteArray = Base64.decode(item._img1, Base64.DEFAULT)
            Glide
                .with(context)
                .asBitmap()
                .load(imageByteArray)
                .into(imageView)

            val pos = adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                itemView.setOnClickListener {
                    itemClick?.onClick(itemView, item, pos)
                }
            }
        }
    }
}