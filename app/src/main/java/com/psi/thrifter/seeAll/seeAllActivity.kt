package com.psi.thrifter.seeAll

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.R

class seeAllActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_all)

        val list = ArrayList<seeAll_item>()
        val item1 = seeAll_item (R.drawable.gambar_dummy,"Kolor Supreme", "EvanPunyashop","Rp. 199.999")

        list.add(item1)
        list.add(item1)
        list.add(item1)
        list.add(item1)
        list.add(item1)
        list.add(item1)


        val rvCart: RecyclerView = findViewById(R.id.rv_cart)
        val listCart = listAllAdapter(list)
        rvCart.adapter = listCart
        rvCart.layoutManager = LinearLayoutManager(this)

    }
}