package org.techtown.animore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_past_card_more.*

class PastFragmentMore : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_past_card_more, container, false)

        return view;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        잘 되는 것 확인함 이후 카드 클릭했을 때 해당하는 카드의 데이터가 넘어갈 수 있도록 바인딩하기
         */

        var dump1 = PastMoreCardData(4, false)
        val MyData:MutableList<PastMoreCardData> = mutableListOf<PastMoreCardData>(dump1)
        val No = PastMoreCardAdapter(requireContext(), MyData)
        pastcard_more.adapter = No
    }
}