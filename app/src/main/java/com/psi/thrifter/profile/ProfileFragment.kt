package com.psi.thrifter.profile

import android.app.AlertDialog
import android.content.Context.MODE_PRIVATE
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.psi.thrifter.R

class ProfileFragment : Fragment(), View.OnClickListener {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//
//        }
//    }
    private lateinit var txtAddress : TextView
    private lateinit var txtBank : TextView
    private lateinit var ejak : TextView
    private lateinit var rel1 : RelativeLayout
    private lateinit var rel2 : LinearLayout
    private lateinit var btnD : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arrowPembayaran = view.findViewById<ImageButton>(R.id.changePayment)
        arrowPembayaran.setOnClickListener(this)
        val arrowAlamat = view.findViewById<ImageButton>(R.id.changeAddress)
        arrowAlamat.setOnClickListener(this)
        rel1 = view.findViewById(R.id.rl1)
        rel2 = view.findViewById(R.id.rl2)
        ejak = view.findViewById(R.id.ed1)
        rel2.visibility = View.GONE
        txtBank = view.findViewById(R.id.bankSaya)
        txtAddress = view.findViewById(R.id.alamatSaya)
        btnD = view.findViewById(R.id.bt1)
        btnD.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        val penyimpanan: SharedPreferences = requireActivity().getSharedPreferences("simpan", MODE_PRIVATE)
        if(penyimpanan.getString("Bank", "") != null){
            val kisah = penyimpanan.getString("Bank", "")
            txtBank.text = kisah
        }
        if (penyimpanan.getString("Alamat","") != null) {
            val cerita = penyimpanan.getString("Alamat", "")
            txtAddress.text = cerita
        }
    }

    override fun onClick(view: View?) {
        if(view?.id == R.id.changePayment) {
//            val ubahPembayaran = AlertDialog.Builder(requireContext())
//            val viewPembayaran: View = layoutInflater.inflate(R.layout.popup_bank_list, null)
//            ubahPembayaran.setView(viewPembayaran)
//            ubahPembayaran.setPositiveButton("OK") {
//                    dialogInterface, i ->
//            }
//            val dialog : AlertDialog = ubahPembayaran.create()
//            dialog.show()
            val items = arrayOf("BANK BNI", "BANK BRI", "BANK MANDIRI", "BANK BCA", "BANK PERMATA", "BANK MEGA", "BANK DANAMON")
            val builder = AlertDialog.Builder(requireContext())
            with(builder)
            {
                setTitle("List of Items")
                setItems(items) { dialog, which ->
//                    var arkansas : TextView = view.findViewById(R.id.bankSaya)
                    val penyimpanan: SharedPreferences = requireActivity().getSharedPreferences("simpan", MODE_PRIVATE)
                    val editor: SharedPreferences.Editor = penyimpanan.edit()
                    editor.putString("Bank", items[which])
                    editor.apply()
                    editor.commit()
                    txtBank.text = items[which]
                }

                setPositiveButton("OK") {
                        dialog: DialogInterface, which: Int ->
                }
                show()
            }

        }
        if (view?.id == R.id.changeAddress) {
            val penyimpanan: SharedPreferences = requireActivity().getSharedPreferences("simpan", AppCompatActivity.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = penyimpanan.edit()
            val ubahAlamat = AlertDialog.Builder(requireContext())
            ubahAlamat.setTitle("Ingin ganti alamat")
//            val viewAlamat: View = layoutInflater.inflate(R.layout.popup_ganti_alamat, null)
//            val editText  = viewAlamat.findViewById<EditText>(R.id.gantiAlamat)
//            ubahAlamat.setView(viewAlamat)
            ubahAlamat.setPositiveButton("Iya") {
                    dialogInterface, i ->
                        rel1.visibility = View.GONE
                        rel2.visibility = View.VISIBLE
            }
            ubahAlamat.setNegativeButton("Tidak") {
                dialogInterface, i ->

            }
            val diane : AlertDialog = ubahAlamat.create()
            diane.show()
        }
        if (view?.id == R.id.bt1) {
            val penyimpanan: SharedPreferences = requireActivity().getSharedPreferences("simpan", AppCompatActivity.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = penyimpanan.edit()
            editor.putString("Alamat", ejak.text.toString())
            editor.apply()
            editor.commit()
            txtAddress.text = ejak.text.toString()
            rel2.visibility = View.GONE
            rel1.visibility = View.VISIBLE
        }
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment ProfileFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            ProfileFragment().apply {
//                arguments = Bundle().apply {
//                }
//            }
//    }
}