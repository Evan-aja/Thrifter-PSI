package com.psi.thrifter.kategori

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.AdapterItem
import com.psi.thrifter.ItemActivity
import com.psi.thrifter.R
import com.psi.thrifter.data.category.Category
import com.psi.thrifter.data.item.Item

class adapterKategori(private val item: List<Category>) : RecyclerView.Adapter<adapterKategori.ViewHolder>() {
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutview = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_recycler_kategori, parent, false)
        return ViewHolder(layoutview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.tv_item_name).text = item[position].Name
            findViewById<ImageView>(R.id.img_item_photo).setImageBitmap(item[position].Photo)
        }
    }

    override fun getItemCount() = item.size
}

class viewModelKategori(parent: MainActivity_kategori): ViewModel(){
    private val ListItem= mutableListOf<Category>()
    init {
        ListItem.add(Category("Baju", BitmapFactory.decodeResource(parent.resources,R.drawable.kategori_baju)))
        ListItem.add(Category("Celana", BitmapFactory.decodeResource(parent.resources,R.drawable.kategori_celana)))
        ListItem.add(Category("Sepatu", BitmapFactory.decodeResource(parent.resources,R.drawable.kategori_sepatu)))
        ListItem.add(Category("Topi", BitmapFactory.decodeResource(parent.resources,R.drawable.kategori_topi)))
    }
    fun getItem()=ListItem
}


