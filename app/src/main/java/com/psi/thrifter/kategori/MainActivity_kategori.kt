package com.psi.thrifter.kategori

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.AdapterItem
import com.psi.thrifter.R
import com.psi.thrifter.viewModelItem

class MainActivity_kategori : AppCompatActivity() {
    lateinit var main : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kategori)
        var actionBar = getSupportActionBar()

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
            actionBar.setCustomView(R.layout.actionbar_kategori)
            actionBar.setHomeAsUpIndicator(R.drawable.back_button);
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

        val VMitems= viewModelKategori(this)
        val adapter= adapterKategori(VMitems.getItem())
        val RVPahlawan=findViewById<RecyclerView>(R.id.recyclerSemuaKategoriPage)
        RVPahlawan.adapter=adapter
        RVPahlawan.layoutManager= GridLayoutManager(this@MainActivity_kategori, 2)


        val todoVM = listOf(
            data_kategori(R.drawable.kategori_baju,"Baju"),
            data_kategori(R.drawable.kategori_celana,"Celana"),
            data_kategori(R.drawable.kategori_sepatu,"topi"),
            data_kategori(R.drawable.kategori_topi,"Topi"),

            )
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}