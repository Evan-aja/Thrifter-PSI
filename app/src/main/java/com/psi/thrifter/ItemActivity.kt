package com.psi.thrifter

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.data.item.Item

class ItemActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.items_view)
        val VMitems=viewModelItem(this)
        val adapter=AdapterItem(VMitems.getItem())
        val RVPahlawan=findViewById<RecyclerView>(R.id.recycledAluminium)
        RVPahlawan.adapter=adapter
        RVPahlawan.layoutManager=LinearLayoutManager(this)
    }
}

class viewModelItem(parent: ItemActivity): ViewModel(){
    private val ListItem= mutableListOf<Item>()
    init {
        ListItem.add(Item("Satu","Dekripsi produk satu","the rabbit","1000000",BitmapFactory.decodeResource(parent.resources,R.drawable.five)))
        ListItem.add(Item("Dua","Deskripsi produk dua","the Junk","2000000",BitmapFactory.decodeResource(parent.resources,R.drawable.four)))
    }
    fun getItem()=ListItem
}

class AdapterItem(var item: MutableList<Item>):RecyclerView.Adapter<AdapterItem.viewHolderItem>(){
    inner class viewHolderItem(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderItem {
        return viewHolderItem(LayoutInflater.from(parent.context).inflate(R.layout.items_recycle,parent,false))
    }

    override fun onBindViewHolder(holder: viewHolderItem, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.Name).text = item[position].Name
            findViewById<TextView>(R.id.description).text = item[position].Description
            findViewById<TextView>(R.id.shop).text = item[position].Shop
            findViewById<TextView>(R.id.price).text = item[position].Price
            findViewById<ImageView>(R.id.photo).setImageBitmap(item[position].Photos)
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

}