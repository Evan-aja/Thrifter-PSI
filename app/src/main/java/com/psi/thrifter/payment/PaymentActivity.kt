package com.psi.payment_page

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.MainActivity
import com.psi.thrifter.R
import com.psi.thrifter.Splashpayment

class PaymentActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var myPayment : TextView
    private lateinit var myAddress : TextView
    private lateinit var myCourier : TextView
    private lateinit var btnPayment : ImageButton
    private lateinit var btnAddress : ImageButton
    private lateinit var btnCourier : ImageButton
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

        myPayment = findViewById(R.id.jenispembayarantxt)
        myAddress = findViewById(R.id.alamattxt)
        myCourier = findViewById(R.id.ekspedisitxt)
        btnPayment = findViewById(R.id.jenispembayaranbtn)
        btnPayment.setOnClickListener(this)
        btnAddress = findViewById(R.id.alamatbtn)
        btnAddress.setOnClickListener(this)
        btnCourier = findViewById(R.id.ekspedisibtn)
        btnCourier.setOnClickListener(this)

        val rvItempayment: RecyclerView = findViewById(R.id.recvitempayment)
        val itempaymentadapter = List_itempaymentadapter(list)
        rvItempayment.adapter = itempaymentadapter
        rvItempayment.layoutManager = LinearLayoutManager(this)

        val button = findViewById<ImageView>(R.id.back_btn)
        button.setOnClickListener {
            startActivity(Intent(this@PaymentActivity, MainActivity::class.java))
            true
        }
        val buttonbayar = findViewById<Button>(R.id.bayarbtn)
        buttonbayar.setOnClickListener {
            startActivity(Intent(this@PaymentActivity, Splashpayment::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        val penyimpanan: SharedPreferences = getSharedPreferences("simpan", MODE_PRIVATE)
        if(penyimpanan.getString("Bank", "") != null){
            val currentBank = penyimpanan.getString("Bank", "")
            myPayment.text = currentBank
        }
        if (penyimpanan.getString("Alamat","") != null) {
            val currentAddress = penyimpanan.getString("Alamat", "")
            myAddress.text = currentAddress
        }
        if (penyimpanan.getString("Kurir", "") != null) {
            val currentCourier = penyimpanan.getString("Kurir", "")
            myCourier.text = currentCourier
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.jenispembayaranbtn) {
            val items = arrayOf("BANK BNI", "BANK BRI", "BANK MANDIRI", "BANK BCA", "BANK PERMATA", "BANK MEGA", "BANK DANAMON")
            val builder = AlertDialog.Builder(this)
            with(builder)
            {
                setTitle("List of Items")
                setItems(items) { dialog, which ->
//                    var arkansas : TextView = view.findViewById(R.id.bankSaya)
                    val penyimpanan: SharedPreferences = getSharedPreferences("simpan", MODE_PRIVATE)
                    val editor: SharedPreferences.Editor = penyimpanan.edit()
                    editor.putString("Bank", items[which])
                    editor.apply()
                    editor.commit()
                    myPayment.text = items[which]
                }

                setPositiveButton("OK") {
                        dialog: DialogInterface, which: Int ->
                }
                show()
            }
        }
        if (v?.id == R.id.alamatbtn) {
            val penyimpanan: SharedPreferences = getSharedPreferences("simpan", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = penyimpanan.edit()
            val alamatDialog = AlertDialog.Builder(this)
            alamatDialog.setTitle("Ganti alamat")
            val viewAlamat: View = layoutInflater.inflate(R.layout.popup_ganti_alamat, null)
            val editText  = viewAlamat.findViewById<EditText>(R.id.gantiAlamat)
            alamatDialog.setView(viewAlamat)
            alamatDialog.setPositiveButton("Ganti") {
                    dialogInterface, i ->
                myAddress.text = editText.text.toString()
                editor.putString("Alamat", editText.text.toString())
                editor.apply()
                editor.commit()
            }
            val diane : AlertDialog = alamatDialog.create()
            diane.show()
        }
        if (v?.id == R.id.ekspedisibtn) {
            val items = arrayOf("SiPalingCepat(Rp 25.000)", "SiPalingGesit(Rp 24.000)", "Je en Es(Rp 20.000)", "Shinobi Express(Rp 21.000)")
            val builder = AlertDialog.Builder(this)
            with(builder)
            {
                setTitle("List of Items")
                setItems(items) { dialog, which ->
                    val penyimpanan: SharedPreferences = getSharedPreferences("simpan", MODE_PRIVATE)
                    val editor: SharedPreferences.Editor = penyimpanan.edit()
                    editor.putString("Kurir", items[which])
                    editor.apply()
                    editor.commit()
                    myCourier.text = items[which]
                }

                setPositiveButton("OK") {
                        dialog: DialogInterface, which: Int ->
                }
                show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val penyimpanan: SharedPreferences = getSharedPreferences("simpan", MODE_PRIVATE)
        if(penyimpanan.getString("Bank", "") != null){
            val currentBank = penyimpanan.getString("Bank", "")
            myPayment.text = currentBank
        }
        if (penyimpanan.getString("Alamat","") != null) {
            val currentAddress = penyimpanan.getString("Alamat", "")
            myAddress.text = currentAddress
        }
        if (penyimpanan.getString("Kurir", "") != null) {
            val currentCourier = penyimpanan.getString("Kurir", "")
            myCourier.text = currentCourier
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.jenispembayaranbtn) {
            val items = arrayOf("BANK BNI", "BANK BRI", "BANK MANDIRI", "BANK BCA", "BANK PERMATA", "BANK MEGA", "BANK DANAMON")
            val builder = AlertDialog.Builder(this)
            with(builder)
            {
                setTitle("List of Items")
                setItems(items) { dialog, which ->
//                    var arkansas : TextView = view.findViewById(R.id.bankSaya)
                    val penyimpanan: SharedPreferences = getSharedPreferences("simpan", MODE_PRIVATE)
                    val editor: SharedPreferences.Editor = penyimpanan.edit()
                    editor.putString("Bank", items[which])
                    editor.apply()
                    editor.commit()
                    myPayment.text = items[which]
                }

                setPositiveButton("OK") {
                        dialog: DialogInterface, which: Int ->
                }
                show()
            }
        }
        if (v?.id == R.id.alamatbtn) {
            val penyimpanan: SharedPreferences = getSharedPreferences("simpan", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = penyimpanan.edit()
            val alamatDialog = AlertDialog.Builder(this)
            alamatDialog.setTitle("Ganti alamat")
            val viewAlamat: View = layoutInflater.inflate(R.layout.popup_ganti_alamat, null)
            val editText  = viewAlamat.findViewById<EditText>(R.id.gantiAlamat)
            alamatDialog.setView(viewAlamat)
            alamatDialog.setPositiveButton("Ganti") {
                    dialogInterface, i ->
                myAddress.text = editText.text.toString()
                editor.putString("Alamat", editText.text.toString())
                editor.apply()
                editor.commit()
            }
            val diane : AlertDialog = alamatDialog.create()
            diane.show()
        }
        if (v?.id == R.id.ekspedisibtn) {
            val items = arrayOf("SiPalingCepat(Rp 25.000)", "SiPalingGesit(Rp 24.000)", "Je en Es(Rp 20.000)", "Shinobi Express(Rp 21.000)")
            val builder = AlertDialog.Builder(this)
            with(builder)
            {
                setTitle("List of Items")
                setItems(items) { dialog, which ->
                    val penyimpanan: SharedPreferences = getSharedPreferences("simpan", MODE_PRIVATE)
                    val editor: SharedPreferences.Editor = penyimpanan.edit()
                    editor.putString("Kurir", items[which])
                    editor.apply()
                    editor.commit()
                    myCourier.text = items[which]
                }

                setPositiveButton("OK") {
                        dialog: DialogInterface, which: Int ->
                }
                show()
            }
        }
    }
}