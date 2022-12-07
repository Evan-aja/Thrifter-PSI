package com.psi.thrifter.seeAll

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.R
import java.util.ArrayList

class listAllAdapter (private val listAll: ArrayList<seeAll_item>):
    RecyclerView.Adapter<listAllAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_see_all, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (photo, name, namaToko, hargaItem) = listAll[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvNamaToko.text = namaToko
        holder.tvHarga.text = hargaItem

        holder.imgPhoto.setOnClickListener {
            Toast.makeText( holder.imgPhoto.context, "You choose ${holder.tvName.text}", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int = listAll.size
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.image_item)
        var tvName: TextView = itemView.findViewById(R.id.tv_nama)
        var tvNamaToko: TextView = itemView.findViewById(R.id.tv_namaToko)
        var tvHarga: TextView = itemView.findViewById(R.id.tv_hargaItem)


    }
}