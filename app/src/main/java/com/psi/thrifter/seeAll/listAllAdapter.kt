package com.psi.thrifter.seeAll

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.R
import com.psi.thrifter.home.OnTrendingClickListener
import com.psi.thrifter.itemData
import kotlin.collections.ArrayList

class listAllAdapter(var listAll: ArrayList<itemData>):
    RecyclerView.Adapter<listAllAdapter.ListViewHolder>(){



    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_see_all, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (photo, name,namaToko, hargaItem) = listAll[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvNamaToko.text = namaToko
        holder.tvHarga.text = hargaItem

//        holder.itemView.setOnClickListener{
//            onTrendingClickListener.onTrendingItemClicked(position)
//        }
    }
    fun setFilteredList(listAll: ArrayList<itemData>){
        this.listAll = listAll
        notifyDataSetChanged()
    }



    override fun getItemCount(): Int = listAll.size
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.image_item)
        val tvName: TextView = itemView.findViewById(R.id.tv_nama)
        val tvNamaToko: TextView = itemView.findViewById(R.id.tv_namaToko)
        val tvHarga: TextView = itemView.findViewById(R.id.tv_hargaItem)

    }
}