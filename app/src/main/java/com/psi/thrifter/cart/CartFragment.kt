package com.psi.thrifter.cart

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.psi.cart_page.cartData
import com.psi.cart_page.listCartAdapter
import com.psi.payment_page.PaymentActivity
import com.psi.thrifter.R
import com.psi.thrifter.kategori.adapterKategori


class CartFragment : Fragment(), OnCartClickListener {
    val list = ArrayList<cartData>()
    private lateinit var txtThree : TextView
    private lateinit var rvCart : RecyclerView
    private lateinit var btnRefresh : Button
    private var listCart = listCartAdapter(list, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_cart,container,false)
        val penyimpanan: SharedPreferences = requireActivity().getSharedPreferences("simpan", AppCompatActivity.MODE_PRIVATE)
        val namaBarang = arrayOf("judul1","judul2","judul3","judul4","judul5")
        for (barang in namaBarang) {
            if(penyimpanan.getString(barang, "")=="") {
                //list.remove(cartData(R.drawable.gambar_dummy, penyimpanan.getString("$barang","").toString(), "AkmalPunya", "Rp. 199.999"))
                continue
            } else {
                when (barang) {
                    "judul1" -> {
                        var item1 = cartData(R.drawable.sp1, penyimpanan.getString("$barang","").toString(), "Toko Alvaro","Rp. 999.999")
                        list.add(item1)
                    }
                    "judul2" -> {
                        var item1 = cartData(R.drawable.sp2, penyimpanan.getString("$barang","").toString(), "Toko Adhi","Rp. 1.199.999")
                        list.add(item1)
                    }
                    "judul3" -> {
                        var item1 = cartData(R.drawable.sp3, penyimpanan.getString("$barang","").toString(), "Toko Evan","Rp. 999.899")
                        list.add(item1)
                    }
                    "judul4" -> {
                        var item1 = cartData(R.drawable.sp4, penyimpanan.getString("$barang","").toString(), "Toko Akmal","Rp. 2.999.899")
                        list.add(item1)
                    }
                    "judul5" -> {
                        var item1 = cartData(R.drawable.sp4, penyimpanan.getString("$barang","").toString(), "AkmalPunya","Rp. 9.999.999")
                        list.add(item1)
                    }
                }
            }

        }

        rvCart = root.findViewById(R.id.rv_cart)

        rvCart.adapter = listCart
        rvCart.layoutManager = LinearLayoutManager(this.context)

        val button = root.findViewById<Button>(R.id.carttopayment_btn)
        button.setOnClickListener{
            startActivity(Intent(this@CartFragment.context, PaymentActivity::class.java))
            true
        }

        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val store : SharedPreferences = requireActivity().getSharedPreferences("simpan", AppCompatActivity.MODE_PRIVATE)
        super.onViewCreated(view, savedInstanceState)
        txtThree = view.findViewById(R.id.textView3)
        val makas : String = store.getInt("subTotal",0).toString()
        txtThree.text = "Rp. $makas"
    }

    fun newInstance(param1: String, param2: String) =
        CartFragment().apply {

        }
//    private fun refresh() {
//        val manager: FragmentManager = requireActivity().supportFragmentManager
//        val ft: FragmentTransaction = manager.beginTransaction()
//        val newFragment: Fragment = this
//        onDestroy()
//        ft.remove(this)
//        ft.replace(this.id, newFragment)
//        //container is the ViewGroup of current fragment
//        ft.addToBackStack(null)
//        ft.commit()
//
//        true
//    }

    override fun onCartClicked(position: Int) {
        val penyimpanan: SharedPreferences = requireActivity().getSharedPreferences("simpan", AppCompatActivity.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = penyimpanan.edit()
        val peta = mapOf("judul1" to 999999,"judul2" to 1199999,"judul3" to 999899, "judul4" to 2999899, "judul5" to 9999999)
        val aranBarang = arrayOf("judul1","judul2","judul3","judul4","judul5")
        for (b in aranBarang) {
            if(list[position].namaItem == penyimpanan.getString(b, "")) {
                val toko : String = list[position].namaToko
                val harga : String = list[position].harga
                editor.putString(b,"")
                editor.putInt("subTotal",penyimpanan.getInt("subTotal",0)- peta.getValue(b))
                editor.apply()
                list.remove(cartData(position, penyimpanan.getString(b,"").toString(), toko, harga))
                show(position)
                break

            }

        }

    }

    private fun show(query:Int?){
        if (query != null){
            val setCartedList = ArrayList<cartData>()
            listCart.setCartList(setCartedList)
        }
    }

}
