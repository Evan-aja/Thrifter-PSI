package com.psi.thrifter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class StartPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)

        val button = findViewById<Button>(R.id.start_btn)
        button.setOnClickListener{
            startActivity(Intent(this@StartPage, MainActivity::class.java))
            true
    }
}
}