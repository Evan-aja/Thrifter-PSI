package com.psi.thrifter.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import com.psi.thrifter.*
import com.psi.thrifter.detail.DetailProductActivity
import com.psi.thrifter.seeAll.seeAllActivity
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), OnTrendingClickListener,OnItemClickListener{
    val listt = ArrayList<itemData>(dataUtil.itemTrending)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    var trending = ArrayList<itemData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home,container,false)


        listt.toObservable()
            .subscribeBy(
                onNext = {val rvTrending: RecyclerView = root.findViewById(R.id.recvtrending)
                    var trendingAdapter = Listtrendingadapter(listt,this)
                    rvTrending.adapter = trendingAdapter
                    rvTrending.layoutManager = LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false)
                },
                onError = {it.printStackTrace()},
                onComplete = { println("onComplete")}
            )

        val list_all = ArrayList<itemData>(dataUtil.itemTrending)
        list_all.toObservable()
            .subscribeBy(
                onNext = {val rvAll: RecyclerView = root.findViewById(R.id.recvlist_all)
                    val all_itemadapter = List_all_itemdata_adapter(list_all,this)
                    rvAll.adapter = all_itemadapter
                    rvAll.layoutManager = GridLayoutManager(this.context, 2, GridLayoutManager.VERTICAL, false)
                },
                onError = {it.printStackTrace()},
                onComplete = { println("onComplete")}
            )

        val tv_lihatSemua = root.findViewById<TextView>(R.id.seeAll)
        tv_lihatSemua.setOnClickListener{
            startActivity(Intent(this@HomeFragment.context, seeAllActivity::class.java))
            true
        }
        return root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onTrendingItemClicked(position: Int) {
        val intent = Intent(this.context, DetailProductActivity::class.java)
        intent.putExtra("judul",listt[position].title)
        intent.putExtra("photo",listt[position].img)
        intent.putExtra("nama_toko",listt[position].namaToko)
        intent.putExtra("harga",listt[position].harga)
        intent.putExtra("deskripsi",listt[position].desc)
        startActivity(intent)
    }

    override fun onItemClicked(position: Int) {
        val intent = Intent(this.context, DetailProductActivity::class.java)
        intent.putExtra("judul",listt[position].title)
        intent.putExtra("photo",listt[position].img)
        intent.putExtra("harga",listt[position].harga)
        intent.putExtra("nama_toko",listt[position].namaToko)
        intent.putExtra("deskripsi",listt[position].desc)
        startActivity(intent)
    }

}


