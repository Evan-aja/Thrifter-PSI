package com.psi.payment_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.MainActivity
import com.psi.thrifter.R

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment_activity)

        val list = ArrayList<itempayment>()
        val itempayment1 =
            itempayment(R.drawable.sp1, "Kaos Elvi's", "EvanPunya Shop", "Rp 599.999")
        val itempayment2 =
            itempayment(R.drawable.sp1, "Kaos Elvi's", "EvanPunya Shop", "Rp 599.999")
        val itempayment3 =
            itempayment(R.drawable.sp1, "Kaos Elvi's", "EvanPunya Shop", "Rp 599.999")
        list.add(itempayment1)
        list.add(itempayment2)
        list.add(itempayment3)

        val rvItempayment: RecyclerView = findViewById(R.id.recvitempayment)
        val itempaymentadapter = List_itempaymentadapter(list)
        rvItempayment.adapter = itempaymentadapter
        rvItempayment.layoutManager = LinearLayoutManager(this)

        val button = findViewById<ImageView>(R.id.back_btn)
        button.setOnClickListener {
            startActivity(Intent(this@PaymentActivity, MainActivity::class.java))
            true
        }
    }
}