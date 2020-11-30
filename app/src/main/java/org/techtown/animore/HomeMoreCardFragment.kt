package org.techtown.animore

import android.app.ActionBar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.normal_card_list
import kotlinx.android.synthetic.main.fragment_home_card_more.*
import kotlinx.android.synthetic.main.more_card_front_layout.*
import java.util.*

class HomeMoreCardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_card_more, container, false)
        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var dump1 = HomeMoreCardFrontData(4, true)

        val MyData:MutableList<HomeMoreCardFrontData> = mutableListOf<HomeMoreCardFrontData>(dump1)

        val No = HomeMoreCardFrontAdapter(requireContext(), MyData)
        more_card_front.adapter = No

    }
}