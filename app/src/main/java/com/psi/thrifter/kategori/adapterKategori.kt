package com.psi.thrifter.kategori

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.R
import com.psi.thrifter.kategori.OnKategoriClickListener

class adapterKategori(private val kategori: List<data_kategori>,private val onKategoriClickListener: OnKategoriClickListener) :
    RecyclerView.Adapter<adapterKategori.ListViewHolder>() {
    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgKategori: ImageView = itemView.findViewById(R.id.img_item_photo)
        var titlekategori: TextView = itemView.findViewById(R.id.tv_item_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutview = LayoutInflater.from(parent.context).inflate(R.layout.activity_recycler_kategori, parent, false)
        return ListViewHolder(layoutview)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (img,title) = kategori[position]
        holder.imgKategori.setImageResource(img)
        holder.titlekategori.text = title

        holder.itemView.setOnClickListener{
            onKategoriClickListener.onKategoriItemClicked(position)
        }
    }

    override fun getItemCount() = kategori.size


}