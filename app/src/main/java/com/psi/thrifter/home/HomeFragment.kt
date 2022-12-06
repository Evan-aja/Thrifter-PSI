package com.psi.thrifter.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.psi.thrifter.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home,container,false)

        val list = ArrayList<trendingdata>()
        val item1 = trendingdata(R.drawable.sp1, "Kaos Suprim", "Rp 999.999")
        val item2 = trendingdata(R.drawable.sp2, "Kaos Sungprim", "Rp 1.199.999")
        val item3 = trendingdata(R.drawable.sp3, "Kaos Elvi's ORI", "Rp 999.899")
        val item4 = trendingdata(R.drawable.sp4, "Billabong Special", "Rp 2.999.899")
        val item5 = trendingdata(R.drawable.sp5, "Nascar Official", "Rp 9.999.999")
        list.add(item1)
        list.add(item2)
        list.add(item3)
        list.add(item4)
        list.add(item5)

        val rvTrending: RecyclerView = root.findViewById(R.id.recvtrending)
        val trendingadapter = Listtrendingadapter(list)
        rvTrending.adapter = trendingadapter
        rvTrending.layoutManager = LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false)


        val list_all = ArrayList<all_itemdata>()
        val item1_all = all_itemdata(R.drawable.sp1, "Kaos Suprim", "Rp 999.999")
        val item2_all = all_itemdata(R.drawable.sp2, "Kaos Sungprim", "Rp 1.199.999")
        val item3_all = all_itemdata(R.drawable.sp3, "Kaos Elvi's ORI", "Rp 999.899")
        val item4_all = all_itemdata(R.drawable.sp4, "Billabong New", "Rp 2.999.899")
        val item5_all = all_itemdata(R.drawable.sp5, "Nascar Official", "Rp 9.999.999")
        val item6_all = all_itemdata(R.drawable.sp6, "RedBull Edition", "Rp 1.299.990")
        list_all.add(item1_all)
        list_all.add(item2_all)
        list_all.add(item3_all)
        list_all.add(item4_all)
        list_all.add(item5_all)
        list_all.add(item6_all)

        val rvAll: RecyclerView = root.findViewById(R.id.recvlist_all)
        val all_itemadapter = List_all_itemdata_adapter(list_all)
        rvAll.adapter = all_itemadapter
        rvAll.layoutManager = GridLayoutManager(this.context, 2, GridLayoutManager.VERTICAL, false)


        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}