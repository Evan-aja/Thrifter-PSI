package com.psi.thrifter

import androidx.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.R

class Listtrendingadapter(private val listtrending: ArrayList<trendingdata>):
        RecyclerView.Adapter<Listtrendingadapter.ListViewHolder>() {
            override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
                val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)
                return ListViewHolder(view)
            }

            override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
                val (img, title, price) = listtrending[position]
                holder.imgtrend.setImageResource(img)
                holder.titletxt.text = title
                holder.pricetxt.text = price
            }

    override fun getItemCount(): Int = listtrending.size

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgtrend: ImageView = itemView.findViewById(R.id.trendimg)
        var titletxt: TextView = itemView.findViewById(R.id.itemname_trend)
        var pricetxt: TextView = itemView.findViewById(R.id.itemharga_trend)
    }
        }