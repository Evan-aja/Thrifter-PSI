package com.psi.thrifter.seeAll

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.Listtrendingadapter
import com.psi.thrifter.R
import com.psi.thrifter.detail.DetailProductActivity
import com.psi.thrifter.home.OnTrendingClickListener
import com.psi.thrifter.home.dataUtil
import com.psi.thrifter.itemData
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import java.util.*
import kotlin.collections.ArrayList

class seeAllActivity : AppCompatActivity(){

    private lateinit var rvCart :RecyclerView
    private lateinit var searcView: SearchView
    private var list = ArrayList<itemData>()
    private var seeAllAdapter = listAllAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_all)

        rvCart = findViewById(R.id.rv_cart)
        searcView = findViewById(R.id.searchView)

        rvCart.setHasFixedSize(true)
        rvCart.layoutManager = LinearLayoutManager(this)
        list = ArrayList(dataUtil.itemTrending)
        list.toObservable()
            .subscribeBy(
                onNext = {
                    seeAllAdapter = listAllAdapter(list)
                    rvCart.adapter = seeAllAdapter

                    searcView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                        override fun onQueryTextSubmit(query: String?): Boolean {
                            return false
                        }

                        override fun onQueryTextChange(newText: String?): Boolean {
                            filterList(newText)
                            return true
                        }
                    })
                },
                onError = {it.printStackTrace()},
                onComplete = { println("onComplete")}
            )

    }
    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<itemData>()
            for (i in list) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            seeAllAdapter.setFilteredList(filteredList)
        }
    }
}

//
//    override fun onTrendingItemClicked(position: Int) {
//        val intent = Intent(this, DetailProductActivity::class.java)
//        intent.putExtra("judul",list[position].title)
//        intent.putExtra("photo",list[position].img)
//        intent.putExtra("harga",list[position].harga)
//        intent.putExtra("nama_toko",list[position].namaToko)
//        intent.putExtra("deskripsi",list[position].desc)
//        startActivity(intent)
//    }
