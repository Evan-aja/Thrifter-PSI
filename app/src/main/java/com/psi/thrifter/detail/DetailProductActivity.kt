package com.psi.thrifter.detail

import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.psi.thrifter.R
import java.lang.Math.abs


class DetailProductActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var  viewPager2: ViewPager2
    private lateinit var handler : Handler
    private lateinit var imageList: ArrayList<Int>
    private lateinit var adapter: ImageAdapter
    private lateinit var btnAddCart : AppCompatButton
    private lateinit var namaBarang : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_produk)
        btnAddCart = findViewById(R.id.button2)

        init()
        setUpTransformer()

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable , 2000)
            }
        })

        val hargaBarang : TextView = findViewById(R.id.tv_harga)
        namaBarang = findViewById(R.id.tv_namaItem)
        val namaToko : TextView = findViewById(R.id.tv_namaToko)
        val deskripsi : TextView = findViewById(R.id.tv_desc)


        val bundle : Bundle?= intent.extras
        val judul = bundle?.getString("judul")
        val harga = bundle?.getString("harga")
        val toko = bundle?.getString("nama_toko")
        val desk = bundle?.getString("deskripsi")

        hargaBarang.text = harga
        namaBarang.text = judul
        namaToko.text = toko
        deskripsi.text = desk

        btnAddCart.setOnClickListener(this)
    }


    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }

    private fun setUpTransformer(){
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - kotlin.math.abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }

        viewPager2.setPageTransformer(transformer)
    }

    private fun init(){
        viewPager2 = findViewById(R.id.viewPager2)
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList.add(R.drawable.gambar_1)
        imageList.add(R.drawable.gambar_2)
        imageList.add(R.drawable.gambar_3)


        adapter = ImageAdapter(imageList, viewPager2)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

    }

    fun getHarga() : Int {
        val stored : SharedPreferences = getSharedPreferences("simpan", MODE_PRIVATE)
        return stored.getInt("subTotal", 0)
    }

    override fun onClick(v: View?) {
        val penyimpanan: SharedPreferences = getSharedPreferences("simpan", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = penyimpanan.edit()
        if (v?.id == R.id.button2) {
            when(namaBarang.text) {
                "Kaos Suprim" -> {
                    editor.putString("judul1", "Kaos Suprim")
                    editor.putInt("subTotal", getHarga()+999999)
                    editor.apply()
                    Toast.makeText(this, "berhasil menambahkan ${namaBarang.text} ke keranjang", Toast.LENGTH_SHORT).show()
                }
                "Kaos Sungprim" -> {
                    editor.putString("judul2", "Kaos Sungprim")
                    editor.putInt("subTotal", getHarga()+1199999)
                    editor.apply()
                    Toast.makeText(this, "berhasil menambahkan ${namaBarang.text} ke keranjang", Toast.LENGTH_SHORT).show()
                }
                "Kaos Elvi's ORI" -> {
                    editor.putString("judul3","Kaos Elvi's ORI")
                    editor.putInt("subTotal", getHarga()+999899)
                    editor.apply()
                    Toast.makeText(this, "berhasil menambahkan ${namaBarang.text} ke keranjang", Toast.LENGTH_SHORT).show()
                }
                "Billabong Special" -> {
                    editor.putString("judul4", "Billabong Special")
                    editor.putInt("subTotal", getHarga()+2999899)
                    editor.apply()
                    Toast.makeText(this, "berhasil menambahkan ${namaBarang.text} ke keranjang", Toast.LENGTH_SHORT).show()
                }
                "Nascar Official" -> {
                    editor.putString("judul5", "Nascar Official")
                    editor.putInt("subTotal", getHarga()+9999999)
                    editor.apply()
                    Toast.makeText(this, "berhasil menambahkan ${namaBarang.text} ke keranjang", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}