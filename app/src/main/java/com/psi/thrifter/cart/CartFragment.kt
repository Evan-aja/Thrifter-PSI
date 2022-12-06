package com.psi.thrifter.cart

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.psi.cart_page.Cart_Item
import com.psi.cart_page.listCartAdapter
import com.psi.payment_page.PaymentActivity
import com.psi.thrifter.R


class CartFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_cart,container,false)
        val list = ArrayList<Cart_Item>()
        val item1 = Cart_Item (R.drawable.gambar_dummy,"Kolor Supreme", "EvanPunyashop","Rp. 199.999")

        list.add(item1)
        list.add(item1)
        list.add(item1)
        list.add(item1)
        list.add(item1)
        list.add(item1)


        val rvCart: RecyclerView = root.findViewById(R.id.rv_cart)
        val listCart = listCartAdapter(list)
        rvCart.adapter = listCart
        rvCart.layoutManager = LinearLayoutManager(this.context)

        val button = root.findViewById<Button>(R.id.carttopayment_btn)
        button.setOnClickListener{
            startActivity(Intent(this@CartFragment.context, PaymentActivity::class.java))
            true
        }

            // Inflate the layout for this fragment
        return root

    }


        fun newInstance(param1: String, param2: String) =
            CartFragment().apply {

            }
    }
