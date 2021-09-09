package com.example.assignment.adapter

import android.content.Context
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.media.CamcorderProfile.get
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.model.GalleryDataVO
import com.example.assignment.model.GalleryVO
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.squareup.picasso.PicassoProvider
import java.lang.reflect.Array.get
import java.nio.file.Paths.get

class MainActivityAdapter(val context: Context ,val dataList : ArrayList<GalleryVO>) : RecyclerView.Adapter<MainActivityAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var singleImageview : ImageView =itemView.findViewById(R.id.singleImageview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.dashboard_design,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var galleryDataVO :GalleryDataVO? = dataList[position].GALLERY?.get(0)
        Picasso.get().load(galleryDataVO!!.filename).fit().centerCrop()
            .into(holder.singleImageview);


    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}