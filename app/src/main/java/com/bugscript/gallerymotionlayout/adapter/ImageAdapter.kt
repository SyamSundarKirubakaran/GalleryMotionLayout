package com.bugscript.gallerymotionlayout.adapter

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bugscript.gallerymotionlayout.R
import com.bugscript.gallerymotionlayout.model.imageData
import com.squareup.picasso.Picasso



class ImageAdapter(val context : Context, val imageList : ArrayList<imageData>, val itemClick : (imageData) -> Unit) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item,p0,false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return imageList.count()
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindViews(imageList[p1])
    }

    inner class ViewHolder(itemView : View, val itemClick : (imageData) -> Unit) : RecyclerView.ViewHolder(itemView){
        private val img = itemView.findViewById<ImageView>(R.id.imageView)

        fun bindViews(image: imageData){
            val builder = Picasso.Builder(context)
            builder.listener(object : Picasso.Listener {
                override fun onImageLoadFailed(picasso: Picasso, uri: Uri, exception: Exception) {
                    Log.e("@@@","${exception.message}")
                }
            })
            builder.build().load(image.url).into(img)
            itemView.setOnClickListener { itemClick(image) }
        }
    }

}