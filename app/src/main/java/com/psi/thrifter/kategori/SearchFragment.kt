package com.psi.thrifter.kategori

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.Listtrendingadapter
import com.psi.thrifter.R
import com.psi.thrifter.detail.DetailProductActivity
import com.psi.thrifter.seeAll.seeBajuActivity
import com.psi.thrifter.seeAll.seeCelanaActivity
import com.psi.thrifter.seeAll.seeSepatuActivity
import com.psi.thrifter.seeAll.seeTopiActivity
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

class SearchFragment : Fragment(),OnKategoriClickListener {
    val todoVM = listOf(
        data_kategori(R.drawable.kategori_baju,"Baju"),
        data_kategori(R.drawable.kategori_celana,"Celana"),
        data_kategori(R.drawable.kategori_sepatu,"Sepatu"),
        data_kategori(R.drawable.kategori_topi,"Topi")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_search,container,false)

        todoVM.toObservable()
            .subscribeBy(
                onNext = {val rvCat:RecyclerView = root.findViewById(R.id.recyclerSemuaKategoriPage)
                    val cat_adapter = adapterKategori(todoVM,this)
                    rvCat.adapter = cat_adapter
                    rvCat.layoutManager = GridLayoutManager(this.context, 2, GridLayoutManager.VERTICAL, false)
                },
                onError = {it.printStackTrace()},
                onComplete = { println("onComplete")}
            )


        return root
    }



    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onKategoriItemClicked(position: Int) {
        if(todoVM[position].nama == "Celana"){
            val intent = Intent(this.context, seeCelanaActivity::class.java)
            startActivity(intent)
        }else if (todoVM[position].nama == "Baju"){
            val intent = Intent(this.context, seeBajuActivity::class.java)
            startActivity(intent)
        }else if (todoVM[position].nama == "Topi") {
            val intent = Intent(this.context, seeTopiActivity::class.java)
            startActivity(intent)
        }else if (todoVM[position].nama == "Sepatu") {
            val intent = Intent(this.context, seeSepatuActivity::class.java)
            startActivity(intent)
        }


    }

}