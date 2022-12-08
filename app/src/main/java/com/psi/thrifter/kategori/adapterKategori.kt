import com.psi.thrifter.R
import com.psi.thrifter.kategori.data_kategori

<<<<<<<< HEAD:app/src/main/java/com/psi/thrifter/adapterTrending.kt
package com.psi.thrifter
========
package com.psi.thrifter.kategori
>>>>>>>> 23a5de3ee01f14f28b8265c3fede2c6cf1a9722f:app/src/main/java/com/psi/thrifter/kategori/adapterKategori.kt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ujicoba.data_trending

<<<<<<<< HEAD:app/src/main/java/com/psi/thrifter/adapterTrending.kt
class adapterTrending(private val trending: List<data_kategori>) : RecyclerView.Adapter<adapterTrending.ViewHolder>() {
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutview = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_recycler_trending, parent, false)
========
class adapterKategori(private val kategori: List<data_kategori>) : RecyclerView.Adapter<adapterKategori.ViewHolder>() {
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutview = LayoutInflater.from(parent.context).inflate(R.layout.activity_recycler_kategori, parent, false)
>>>>>>>> 23a5de3ee01f14f28b8265c3fede2c6cf1a9722f:app/src/main/java/com/psi/thrifter/kategori/adapterKategori.kt
        return ViewHolder(layoutview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
<<<<<<<< HEAD:app/src/main/java/com/psi/thrifter/adapterTrending.kt
        val pakaian = trending[position]
        holder.view.findViewById<ImageView>(R.id.img_item_photo)
            .setImageDrawable(holder.view.context.getDrawable(pakaian.image))
        holder.view.findViewById<TextView>(R.id.tv_item_name).text = "${pakaian.nama}"
        holder.view.findViewById<TextView>(R.id.tv_item_price).text = "${pakaian.harga}"
    }

    override fun getItemCount() = trending.size
}
========
        val pahlawan = kategori[position]
        holder.view.findViewById<ImageView>(R.id.img_item_photo).setImageDrawable(holder.view.context.getDrawable(pahlawan.image))
        holder.view.findViewById<TextView>(R.id.tv_item_name).text = "${pahlawan.nama}"
    }

    override fun getItemCount() = kategori.size
}
>>>>>>>> 23a5de3ee01f14f28b8265c3fede2c6cf1a9722f:app/src/main/java/com/psi/thrifter/kategori/adapterKategori.kt
