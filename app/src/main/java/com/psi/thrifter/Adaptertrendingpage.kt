package com.example.ujicoba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.R

class adaptertrendingpage(private val trending: List<data_trending>) : RecyclerView.Adapter<adaptertrendingpage.ViewHolder>() {
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutview = LayoutInflater.from(parent.context).inflate(R.layout.activity_recycler_trending, parent, false)
        return ViewHolder(layoutview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pakaian = trending[position]
        holder.view.findViewById<ImageView>(R.id.img_item_photo).setImageDrawable(holder.view.context.getDrawable(pakaian.image))
        holder.view.findViewById<TextView>(R.id.tv_item_name).text = "${pakaian.nama}"
        holder.view.findViewById<TextView>(R.id.tv_item_price).text = "${pakaian.harga}"
    }

    override fun getItemCount() = trending.size
}