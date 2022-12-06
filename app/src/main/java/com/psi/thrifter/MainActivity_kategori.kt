package com.example.ujicoba

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.R

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


        val todoVM = listOf(
            data_kategori(R.drawable.account_profile_user,"A"),
            data_kategori(R.drawable.account_profile_user,"B"),
            data_kategori(R.drawable.account_profile_user,"C"),
            data_kategori(R.drawable.account_profile_user,"C"),
            data_kategori(R.drawable.account_profile_user,"C"),
            data_kategori(R.drawable.account_profile_user,"C"),
            data_kategori(R.drawable.account_profile_user,"C"),
            data_kategori(R.drawable.account_profile_user,"C"),
            data_kategori(R.drawable.account_profile_user,"C"),
            data_kategori(R.drawable.account_profile_user,"C"),
            data_kategori(R.drawable.account_profile_user,"D")
        )

        main = findViewById(R.id.recyclerSemuaKategoriPage)
        main.apply {
            layoutManager = GridLayoutManager(this@MainActivity_kategori, 2)
            adapter = adapterKategori(todoVM)
        }

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