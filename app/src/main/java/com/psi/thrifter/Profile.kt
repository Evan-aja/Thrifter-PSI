package com.psi.thrifter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var theBottom : BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        theBottom.selectedItemId = R.id.propil

        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_new_24)
    }
}