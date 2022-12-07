package com.psi.thrifter.kategori

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.R

class SearchFragment : Fragment() {
    lateinit var main: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_search,container,false)


        val todoVM = listOf(
            data_kategori(R.drawable.kategori_baju,"Baju"),
            data_kategori(R.drawable.kategori_celana,"Celana"),
            data_kategori(R.drawable.kategori_sepatu,"topi"),
            data_kategori(R.drawable.kategori_topi,"Topi")

            )

        main = root.findViewById(R.id.recyclerSemuaKategoriPage)
        main.apply {
            layoutManager = GridLayoutManager(this.context, 2)
            adapter = adapterKategori(todoVM)
        }

        return root
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}