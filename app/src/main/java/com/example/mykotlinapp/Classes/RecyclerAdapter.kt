package com.example.mykotlinapp.Classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlinapp.R

class RecyclerAdapter(val menuList: ArrayList<RecyclerDataClass>) : RecyclerView.Adapter<RecyclerAdapter.MyVieHolder>(){

    class MyVieHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.img)
        val title: TextView = itemView.findViewById(R.id.txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVieHolder {
        var viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout,parent,false)
        return MyVieHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: MyVieHolder, position: Int) {
       holder.title.text = menuList[position].title
        holder.img.setImageResource(menuList[position].img!!)

    }

    override fun getItemCount(): Int {
        return menuList.size
    }
}