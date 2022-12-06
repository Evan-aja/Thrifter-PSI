package com.psi.payment_page

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.R


class List_itempaymentadapter(private val list_itempayment: ArrayList<itempayment>):
        RecyclerView.Adapter<List_itempaymentadapter.ListViewHolder>() {
            override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
                val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_payment_list, viewGroup, false)
                return ListViewHolder(view)
            }

            override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
                val (img, title, toko, harga) = list_itempayment[position]
                holder.img_itempayment.setImageResource(img)
                holder.title_itempayment.text = title
                holder.toko_itempayment.text = toko
                holder.harga_itempayment.text = harga
            }

            override fun getItemCount(): Int = list_itempayment.size

            inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
                var img_itempayment: ImageView = itemView.findViewById(R.id.itemlist_img)
                var title_itempayment: TextView = itemView.findViewById(R.id.item_nametxt)
                var toko_itempayment: TextView = itemView.findViewById(R.id.namatokotxt)
                var harga_itempayment: TextView = itemView.findViewById(R.id.hargaitemtxt)
            }
        }