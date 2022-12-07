package com.example.ujicoba32

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ujicoba.data_trending
import com.example.ujicoba.adaptertrendingpage
import com.psi.thrifter.R

class MainActivity : AppCompatActivity() {
    lateinit var main: RecyclerView

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
            //database
        )

        main = findViewById(R.id.recyclerSemuaKategoriPage)
        main.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = adaptertrendingpage(todoVM)
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