package com.example.assignment.adapter

import android.content.Context
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.media.CamcorderProfile.get
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
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
        var recyclerView : RecyclerView =itemView.findViewById(R.id.recyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.dashboard_design,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val galleryDataVO  = dataList[position].GALLERY
        val listImageAdapter =ListImageAdapter(context,galleryDataVO!!)
        holder.recyclerView.apply {
            layoutManager= GridLayoutManager(this.context,if(galleryDataVO.size>2) 2 else galleryDataVO.size)
            adapter=listImageAdapter
        }
    }

    override fun getItemCount(): Int {

        return dataList.size
    }
}

