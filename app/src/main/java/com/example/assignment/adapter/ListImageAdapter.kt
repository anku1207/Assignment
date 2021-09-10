package com.example.assignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.model.GalleryDataVO
import com.squareup.picasso.Picasso

class ListImageAdapter(context: Context) :RecyclerView.Adapter<ListImageAdapter.ViewHolder>(){
    var showDataList : ArrayList<GalleryDataVO> = ArrayList()
    var context: Context = context

    constructor(context: Context ,dataList : ArrayList<GalleryDataVO> ,fullDataList : ArrayList<GalleryDataVO>): this(context) {
        this.showDataList=dataList
    }

    companion object{
        fun dpToPx(dp: Int, context: Context): Int {
            val density = context.resources.displayMetrics.density
            return Math.round(dp.toFloat() * density)
        }
    }

   inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val imageview :ImageView =itemView.findViewById(R.id.list_image)
        var listLayout: LinearLayout = itemView.findViewById(R.id.listLayout)
        var imagetext :TextView = itemView.findViewById(R.id.imagetext)
        init {
            if(showDataList.size>2){
                listLayout.layoutParams.height = dpToPx(150 , context)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.image_list_design , parent ,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imagePath=showDataList[position].filename
        Picasso.get().load(imagePath).fit().centerCrop()
            .into(holder.imageview);

        if(showDataList.size>4 && position+1==4){
            holder.imagetext.visibility=View.VISIBLE
            holder.imagetext.text="${showDataList.size-4}  more image"
        }else{
            holder.imagetext.visibility=View.GONE
        }
    }

    override fun getItemCount(): Int {
       return if(showDataList.size>4) 4 else showDataList.size
    }
}