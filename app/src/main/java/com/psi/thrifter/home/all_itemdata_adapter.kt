package com.psi.thrifter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.home.OnItemClickListener
import com.psi.thrifter.home.OnTrendingClickListener

class List_all_itemdata_adapter(private val list_all_itemdata: ArrayList<itemData>,private val onItemClickListener: OnItemClickListener):
    RecyclerView.Adapter<List_all_itemdata_adapter.ListViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item2, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (img, title, price) = list_all_itemdata[position]
        holder.img_all.setImageResource(img)
        holder.titletxt.text = title
        holder.pricetxt.text = price
        holder.itemView.setOnClickListener{
            onItemClickListener.onItemClicked(position)
        }
    }

    override fun getItemCount(): Int = list_all_itemdata.size

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var img_all: ImageView = itemView.findViewById(R.id.allimg)
        var titletxt: TextView = itemView.findViewById(R.id.itemname_all)
        var pricetxt: TextView = itemView.findViewById(R.id.itemharga_all)
    }
}