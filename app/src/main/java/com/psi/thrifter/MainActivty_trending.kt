package com.psi.thrifter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ujicoba.data_trending

class MainActivty_trending: AppCompatActivity() {
    lateinit var main : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trending)
        var actionBar = supportActionBar

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            actionBar.setCustomView(R.layout.actionbar_trending)
            actionBar.setHomeAsUpIndicator(R.drawable.back_button)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }


        val todoVM = listOf(
            data_trending(R.drawable.account_profile_user, "Aadasd", "Rp 989.989"),
            data_trending(R.drawable.account_profile_user, "Basfasfa", "Rp 1.239.989"),
            data_trending(R.drawable.account_profile_user, "Casfasf", "Rp 9.129.989"),
            data_trending(R.drawable.account_profile_user, "Dasfasf", "Rp 29.989"),
        )

        main = findViewById(R.id.recyclerSemuaKategoriPage)
        main.apply {
            layoutManager = GridLayoutManager(this@MainActivty_trending, 2)
            adapter = adapterTrending(todoVM)
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