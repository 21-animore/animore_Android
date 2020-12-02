package org.techtown.animore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_past_card_more.*

class HomeMoreFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_card_more, container, false)

        return view;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //카드 유형에 맞게 상단바 색 바꿔야 함

        /*
        var dump1 = PastMoreCardData(4, false)
        val MyData:MutableList<PastMoreCardData> = mutableListOf<PastMoreCardData>(dump1)
        val No = PastMoreCardAdapter(requireContext(), MyData)
        pastcard_more.adapter = No
         */
    }
}